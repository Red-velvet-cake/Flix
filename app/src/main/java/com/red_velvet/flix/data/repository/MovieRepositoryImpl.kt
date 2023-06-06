package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.local.database.dao.MovieDao
import com.red_velvet.flix.data.remote.MoviesService
import com.red_velvet.flix.data.remote.recoures.movie.MovieResource
import com.red_velvet.flix.data.repository.mapper.movie.toModel
import com.red_velvet.flix.data.repository.mapper.movie.toNowPlayingMovieEntityList
import com.red_velvet.flix.data.repository.mapper.movie.toNowPlayingMoviesModels
import com.red_velvet.flix.data.repository.mapper.movie.toPopularMovieEntityList
import com.red_velvet.flix.data.repository.mapper.movie.toPopularMoviesModels
import com.red_velvet.flix.data.repository.mapper.movie.toTopRatedMovieEntityList
import com.red_velvet.flix.data.repository.mapper.movie.toTopRatedMoviesModels
import com.red_velvet.flix.data.repository.mapper.movie.toUpcomingMovieEntityList
import com.red_velvet.flix.data.repository.mapper.movie.toUpcomingMoviesModels
import com.red_velvet.flix.data.repository.mapper.toModel
import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.entity.TrailerEntity
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import com.red_velvet.flix.domain.utils.ExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val moviesService: MoviesService,
    private val movieDao: MovieDao,
    private val exceptionHandler: ExceptionHandler
) : MovieRepository {

    override fun getPopularMovies(
        page: Int?, region: String?, language: String?
    ): Flow<List<MovieEntity>> {
        return movieDao.getPopularMovies().map { it.toPopularMoviesModels() }
    }

    override suspend fun refreshPopularMovies() {
        moviesService.getPopularMovies().let { popularMoviesResponse ->
            if (popularMoviesResponse.isSuccessful) {
                popularMoviesResponse.body()?.items?.toPopularMovieEntityList()
                    .let {
                        movieDao.insertPopularMovies(it!!)
                    }
            }
        }
    }


    override fun getUpcomingMovies(
        page: Int?, region: String?, language: String?
    ): Flow<List<MovieEntity>> {
        return movieDao.getUpcomingMovies().map { it.toUpcomingMoviesModels() }
    }

    override suspend fun refreshUpcomingMovies() {
        moviesService.getUpcomingMovies().let { upcomingMoviesResponse ->
            if (upcomingMoviesResponse.isSuccessful) {
                upcomingMoviesResponse.body()?.items?.toUpcomingMovieEntityList()
                    .let {
                        movieDao.insertUpcomingMovies(it!!)
                    }
            }
        }
    }


    override fun getNowPlayingMovies(
        page: Int?, region: String?, language: String?
    ): Flow<List<MovieEntity>> {
        return movieDao.getNowPlayingMovies().map { it.toNowPlayingMoviesModels() }
    }

    override suspend fun refreshNowPlayingMovies() {
        moviesService.getUpcomingMovies().let { nowPlayingMoviesResponse ->
            if (nowPlayingMoviesResponse.isSuccessful) {
                nowPlayingMoviesResponse.body()?.items?.toNowPlayingMovieEntityList()
                    .let {
                        movieDao.insertNowPlayingMovies(it!!)
                    }
            }
        }
    }

    override fun getTopRatedMovies(
        page: Int?, region: String?, language: String?
    ): Flow<List<MovieEntity>> {
        return movieDao.getTopRatedMovies().map { it.toTopRatedMoviesModels() }
    }

    override suspend fun refreshTopRatedMovies() {
        moviesService.getUpcomingMovies().let { topRatedMoviesResponse ->
            if (topRatedMoviesResponse.isSuccessful) {
                topRatedMoviesResponse.body()?.items?.toTopRatedMovieEntityList()
                    .let {
                        movieDao.insertTopRatedMovies(it!!)
                    }
            }
        }
    }

    override suspend fun getMovieDetails(movieId: Int): MovieEntity {
        val response = moviesService.getMovieDetails(movieId)
        if (response.isSuccessful) {
            return response.body()?.toModel()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }


    override suspend fun getMovieKeywords(movieId: Int): List<String> {
        val response = moviesService.getMovieKeywords(movieId)
        if (response.isSuccessful) {
            return response.body()?.toModel()!!
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
            return response.body()?.items?.toModel()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getMovieTrailers(movieId: Int, language: String?): List<TrailerEntity> {
        val response = moviesService.getMovieTrailers(movieId, language)
        if (response.isSuccessful) {
            return response.body()?.toModel()!!
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
            return response.body()?.items?.toModel()!!
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
            return response.body()?.items?.toModel()!!
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
            return response.body()?.items?.toModel()!!
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
            return response.body()?.items?.toModel()!!
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
            return response.body()?.items?.toModel()!!
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
            return response.body()?.items?.toModel()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun discoverMovies(
        includeAdult: Boolean,
        includeVideo: Boolean,
        language: String?,
        page: Int?,
        primaryReleaseYear: Int?,
        primaryReleaseDateGte: String?,
        primaryReleaseDateLte: String?,
        region: String?,
        releaseDateGte: String?,
        releaseDateLte: String?,
        sortBy: String?,
        voteAverageGte: Double?,
        voteAverageLte: Double?,
        voteCountGte: Int?,
        voteCountLte: Int?,
        watchRegion: String?,
        withCast: String?,
        withCrew: String?,
        withGenres: String?,
        withKeywords: String?,
        withOriginCountry: String?,
        withOriginalLanguage: String?,
        withPeople: String?,
        withReleaseType: Int?,
        withRuntimeGte: Int?,
        withRuntimeLte: Int?,
        withWatchMonetizationTypes: String?,
        withWatchProviders: String?,
        withoutGenres: String?,
        withoutKeywords: String?,
        withoutWatchProviders: String?,
        withoutCompanies: String?,
        year: Int?
    ): List<MovieEntity> {
        val response = moviesService.discoverMovies(
            includeAdult,
            includeVideo,
            language,
            page,
            primaryReleaseYear,
            primaryReleaseDateGte,
            primaryReleaseDateLte,
            region,
            releaseDateGte,
            releaseDateLte,
            sortBy,
            voteAverageGte,
            voteAverageLte,
            voteCountGte,
            voteCountLte,
            watchRegion,
            withCast,
            withCrew,
            withGenres,
            withKeywords,
            withOriginCountry,
            withOriginalLanguage,
            withPeople,
            withReleaseType,
            withRuntimeGte,
            withRuntimeLte,
            withWatchMonetizationTypes,
            withWatchProviders,
            withoutGenres,
            withoutKeywords,
            withoutWatchProviders,
            withoutCompanies,
            year
        )
        if (response.isSuccessful) {
            return response.body()?.items?.toModel()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

}