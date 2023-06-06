package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.local.database.dao.MovieDao
import com.red_velvet.flix.data.remote.MoviesService
import com.red_velvet.flix.data.remote.recoures.movie.MovieResource
import com.red_velvet.flix.data.repository.mapper.movie.toEntity
import com.red_velvet.flix.data.repository.mapper.movie.toNowPlayingMovieDto
import com.red_velvet.flix.data.repository.mapper.movie.toNowPlayingMoviesEntity
import com.red_velvet.flix.data.repository.mapper.movie.toPopularMovieDto
import com.red_velvet.flix.data.repository.mapper.movie.toPopularMoviesEntity
import com.red_velvet.flix.data.repository.mapper.movie.toTopRatedMovieDto
import com.red_velvet.flix.data.repository.mapper.movie.toTopRatedMoviesEntity
import com.red_velvet.flix.data.repository.mapper.movie.toUpcomingMovieDto
import com.red_velvet.flix.data.repository.mapper.movie.toUpcomingMoviesEntity
import com.red_velvet.flix.data.repository.mapper.toEntity
import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.entity.TrailerEntity
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import com.red_velvet.flix.domain.utils.ExceptionHandler
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val moviesService: MoviesService,
    private val movieDao: MovieDao,
    private val exceptionHandler: ExceptionHandler
) : MovieRepository {

    override suspend fun getPopularMovies(
        page: Int?, region: String?, language: String?
    ): List<MovieEntity> {
        return movieDao.getPopularMovies().toPopularMoviesEntity()
    }

    override suspend fun refreshPopularMovies() {
        moviesService.getPopularMovies().let { popularMoviesResponse ->
            if (popularMoviesResponse.isSuccessful) {
                popularMoviesResponse.body()?.items?.toPopularMovieDto()
                    .let {
                        movieDao.insertPopularMovies(it!!)
                    }
            }
        }
    }


    override suspend fun getUpcomingMovies(
        page: Int?, region: String?, language: String?
    ): List<MovieEntity> {
        return movieDao.getUpcomingMovies().toUpcomingMoviesEntity()
    }

    override suspend fun refreshUpcomingMovies() {
        moviesService.getUpcomingMovies().let { upcomingMoviesResponse ->
            if (upcomingMoviesResponse.isSuccessful) {
                upcomingMoviesResponse.body()?.items?.toUpcomingMovieDto()
                    .let {
                        movieDao.insertUpcomingMovies(it!!)
                    }
            }
        }
    }


    override suspend fun getNowPlayingMovies(
        page: Int?, region: String?, language: String?
    ): List<MovieEntity> {
        return movieDao.getNowPlayingMovies().toNowPlayingMoviesEntity()
    }

    override suspend fun refreshNowPlayingMovies() {
        moviesService.getUpcomingMovies().let { nowPlayingMoviesResponse ->
            if (nowPlayingMoviesResponse.isSuccessful) {
                nowPlayingMoviesResponse.body()?.items?.toNowPlayingMovieDto()
                    .let {
                        movieDao.insertNowPlayingMovies(it!!)
                    }
            }
        }
    }

    override suspend fun getTopRatedMovies(
        page: Int?, region: String?, language: String?
    ): List<MovieEntity> {
        return movieDao.getTopRatedMovies().toTopRatedMoviesEntity()
    }

    override suspend fun refreshTopRatedMovies() {
        moviesService.getUpcomingMovies().let { topRatedMoviesResponse ->
            if (topRatedMoviesResponse.isSuccessful) {
                topRatedMoviesResponse.body()?.items?.toTopRatedMovieDto()
                    .let {
                        movieDao.insertTopRatedMovies(it!!)
                    }
            }
        }
    }

    override suspend fun getMovieDetails(movieId: Int): MovieEntity {
        val response = moviesService.getMovieDetails(movieId)
        if (response.isSuccessful) {
            return response.body()?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }


    override suspend fun getMovieKeywords(movieId: Int): List<String> {
        val response = moviesService.getMovieKeywords(movieId)
        if (response.isSuccessful) {
            return response.body()?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getSimilarMovies(
        movieId: Int,
        page: Int?,
        language: String?
    ): List<MovieEntity> {
        val response = moviesService.getSimilarMovies(movieId, page, language)
        if (response.isSuccessful) {
            return response.body()?.items?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getMovieTrailers(movieId: Int, language: String?): List<TrailerEntity> {
        val response = moviesService.getMovieTrailers(movieId, language)
        if (response.isSuccessful) {
            return response.body()?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getLatestMovie(): MovieResource {
        val response = moviesService.getLatestMovie()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getMovieRecommendations(
        movieId: Int,
        page: Int?,
        language: String?
    ): List<MovieEntity> {
        val response = moviesService.getMovieRecommendations(movieId, page, language)
        if (response.isSuccessful) {
            return response.body()?.items?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun rateMovie(movieId: Int, rating: Double) {
        val response = moviesService.rateMovie(movieId, rating)
        if (!response.isSuccessful) {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun deleteMovieRating(movieId: Int) {
        val response = moviesService.deleteMovieRating(movieId)
        if (!response.isSuccessful) {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getMovieReviews(
        movieId: Int,
        page: Int?,
        language: String?
    ): List<ReviewEntity> {
        val response = moviesService.getMovieReviews(movieId, page, language)
        if (response.isSuccessful) {
            return response.body()?.items?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getMoviesWatchlist(
        accountId: Int,
        language: String?,
        page: Int?,
        sortBy: String?
    ): List<MovieEntity> {
        val response = moviesService.getMoviesWatchlist(accountId, language, page, sortBy)
        if (response.isSuccessful) {
            return response.body()?.items?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getFavoriteMovies(
        accountId: Int,
        language: String?,
        page: Int?,
        sortBy: String?
    ): List<MovieEntity> {
        val response = moviesService.getFavoriteMovies(accountId, language, page, sortBy)
        if (response.isSuccessful) {
            return response.body()?.items?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun search(
        query: String,
        includeAdult: Boolean,
        language: String?,
        page: Int?
    ): List<MovieEntity> {
        val response = moviesService.search(query, includeAdult, language, page)
        if (response.isSuccessful) {
            return response.body()?.items?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getMoviesByKeyword(
        keywordId: Int,
        includeAdult: Boolean,
        language: String?,
        page: Int?,
        region: String?
    ): List<MovieEntity> {
        val response = moviesService.getMoviesByKeyword(
            keywordId,
            includeAdult,
            language,
            page,
            region
        )
        if (response.isSuccessful) {
            return response.body()?.items?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun discoverMovies(
        includeAdult: Boolean,
        language: String?,
        page: Int?,
        sortBy: String?,
        voteAverageGte: Double?,
        year: Int?
    ): List<MovieEntity> {
        val response = moviesService.discoverMovies(
            includeAdult,
            language,
            page,
            sortBy,
            voteAverageGte,
            year
        )
        if (response.isSuccessful) {
            return response.body()?.items?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

}