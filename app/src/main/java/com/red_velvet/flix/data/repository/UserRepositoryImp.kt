package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.local.database.dao.UserDao
import com.red_velvet.flix.data.local.sharedPrefs.SharedPrefs
import com.red_velvet.flix.data.remote.MoviesService
import com.red_velvet.flix.data.remote.dtos.account.AccountDto
import com.red_velvet.flix.data.remote.dtos.auth.LoginRequest
import com.red_velvet.flix.data.repository.mapper.movie.toFavoriteMovieEntityList
import com.red_velvet.flix.data.repository.mapper.movie.toMovieEntityList
import com.red_velvet.flix.data.repository.mapper.movie.toWatchedMovieEntityList
import com.red_velvet.flix.data.repository.mapper.series.toFavoriteSeriesEntityList
import com.red_velvet.flix.data.repository.mapper.series.toSeriesEntityList
import com.red_velvet.flix.data.repository.mapper.series.toWatchedSeriesEntityList
import com.red_velvet.flix.domain.model.movie.Movie
import com.red_velvet.flix.domain.model.series.TVShow
import com.red_velvet.flix.domain.utils.ExceptionHandler
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val service: MoviesService,
    private val userDao: UserDao,
    private val sharedPrefs: SharedPrefs,
    private val exceptionHandler: ExceptionHandler
) : UserRepository {
    override suspend fun login(userName: String, password: String) {
        val response =
            service.validateRequestTokenWithLogin(
                LoginRequest(
                    userName,
                    password,
                    sharedPrefs.getToken()
                )
            )
        if (response.isSuccessful) {
            sharedPrefs.getToken()?.let { createSession(it) }
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun logout() {
        sharedPrefs.clearSessionId()
    }

    override suspend fun getAccountDetails(): AccountDto {
        val response = service.getAccountDetails()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getSessionId(): String? {
        return sharedPrefs.getSessionId()
    }

    override suspend fun getFavoriteMovies(
        language: String?,
        page: Int?,
        sortBy: String?
    ): List<Movie> {
        val response = service.getFavoriteMovies(language, page, sortBy)
        if (response.isSuccessful) {
            return response.body()?.items?.toMovieEntityList() ?: emptyList()
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getCachedFavoriteMovies(): List<Movie> {
        return userDao.getAllFavoriteMovies().toFavoriteMovieEntityList()
    }

    override suspend fun getFavoriteSeries(
        language: String?,
        page: Int?,
        sortBy: String?
    ): List<TVShow> {
        val response = service.getFavoriteTvShows(language, page, sortBy)
        if (response.isSuccessful) {
            return response.body()?.items?.toSeriesEntityList() ?: emptyList()
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getCachedFavoriteSeries(): List<TVShow> {
        return userDao.getAllFavoriteSeries().toFavoriteSeriesEntityList()
    }

    override suspend fun getMoviesWatchList(
        language: String?,
        page: Int?,
        sortBy: String?
    ): List<Movie> {
        val response = service.getMoviesWatchlist(language, page, sortBy)
        if (response.isSuccessful) {
            return response.body()?.items?.toMovieEntityList() ?: emptyList()
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getCachedMoviesWatchList(): List<Movie> {
        return userDao.getAllWatchedMovies().toWatchedMovieEntityList()
    }

    override suspend fun getSeriesWatchList(
        language: String?,
        page: Int?,
        sortBy: String?
    ): List<TVShow> {
        val response = service.getTvShowsWatchlist(language, page, sortBy)
        if (response.isSuccessful) {
            return response.body()?.items?.toSeriesEntityList() ?: emptyList()
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getCachedSeriesWatchList(): List<TVShow> {
        return userDao.getAllWatchedSeries().toWatchedSeriesEntityList()
    }

    private suspend fun saveSessionId(sessionId: String) {
        sharedPrefs.setSessionId(sessionId)
    }

    private suspend fun createSession(requestToken: String) {
        val response = service.createSession(requestToken)
        if (response.isSuccessful) {
            sharedPrefs.setSessionId(response.body()?.sessionId!!)
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    private suspend fun refreshRequestToken() {
        val response = service.getRequestToken()
        if (response.isSuccessful) {
            sharedPrefs.setToken(response.body()?.requestToken!!)
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

}