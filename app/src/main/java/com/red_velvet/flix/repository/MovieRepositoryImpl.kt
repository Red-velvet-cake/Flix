package com.red_velvet.flix.repository

import com.red_velvet.flix.data.local.database.dao.MovieDao
import com.red_velvet.flix.data.remote.APIErrorHandler
import com.red_velvet.flix.data.remote.MoviesService
import com.red_velvet.flix.data.repository.mapper.movie.toEntity
import com.red_velvet.flix.data.repository.mapper.movie.toNowPlayingMovieDto
import com.red_velvet.flix.data.repository.mapper.movie.toNowPlayingMoviesEntity
import com.red_velvet.flix.data.repository.mapper.movie.toPopularMovieDto
import com.red_velvet.flix.data.repository.mapper.movie.toPopularMoviesEntity
import com.red_velvet.flix.data.repository.mapper.movie.toTopRatedMovieDto
import com.red_velvet.flix.data.repository.mapper.movie.toTopRatedMoviesEntity
import com.red_velvet.flix.data.repository.mapper.movie.toUpComingMovieDto
import com.red_velvet.flix.data.repository.mapper.movie.toUpcomingMoviesEntity
import com.red_velvet.flix.data.repository.mapper.toEntity
import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.entity.TrailerEntity
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val moviesService: MoviesService,
    private val movieDao: MovieDao,
    apiErrorHandler: APIErrorHandler
) : MovieRepository, com.red_velvet.flix.repository.BaseRepository(apiErrorHandler) {
    override suspend fun getPopularMovies(
        page: Int?,
        region: String?,
        language: String?
    ): List<MovieEntity> {
        return wrapApiCall { moviesService.getPopularMovies(page, region, language) }
            .items.toEntity()
    }

    override suspend fun getUpcomingMovies(
        page: Int?,
        region: String?,
        language: String?
    ): List<MovieEntity> {
        return wrapApiCall { moviesService.getUpcomingMovies(page, region, language) }
            .items.toEntity()
    }

    override suspend fun getNowPlayingMovies(
        page: Int?,
        region: String?,
        language: String?
    ): List<MovieEntity> {
        return wrapApiCall { moviesService.getNowPlayingMovies(page, region, language) }
            .items.toEntity()
    }

    override suspend fun getTopRatedMovies(
        page: Int?,
        region: String?,
        language: String?
    ): List<MovieEntity> {
        return wrapApiCall { moviesService.getTopRatedMovies(page, region, language) }
            .items.toEntity()
    }


    override suspend fun getMovieDetails(movieId: Int): MovieEntity {
        return wrapApiCall { moviesService.getMovieDetails(movieId) }
            .toEntity()
    }

    override suspend fun getMovieKeywords(movieId: Int): List<String> {
        return wrapApiCall { moviesService.getMovieKeywords(movieId) }
            .toEntity()
    }

    override suspend fun getSimilarMovies(
        movieId: Int,
        page: Int?,
        language: String?
    ): List<MovieEntity> {
        return wrapApiCall { moviesService.getSimilarMovies(movieId, page, language) }
            .items.toEntity()
    }

    override suspend fun getMovieTrailers(movieId: Int, language: String?): List<TrailerEntity> {
        return wrapApiCall { moviesService.getMovieTrailers(movieId, language) }
            .toEntity()
    }

    override suspend fun getLatestMovie(): MovieEntity {
        return wrapApiCall { moviesService.getLatestMovie() }
            .toEntity()
    }

    override suspend fun getMovieRecommendations(
        movieId: Int,
        page: Int?,
        language: String?
    ): List<MovieEntity> {
        return wrapApiCall { moviesService.getMovieRecommendations(movieId, page, language) }
            .items.toEntity()
    }

    override suspend fun rateMovie(movieId: Int, rating: Double) {
        wrapApiCall { moviesService.rateMovie(movieId, rating) }
    }

    override suspend fun deleteMovieRating(movieId: Int) {
        wrapApiCall { moviesService.deleteMovieRating(movieId) }
    }

    override suspend fun getMovieReviews(
        movieId: Int,
        page: Int?,
        language: String?
    ): List<ReviewEntity> {
        return wrapApiCall { moviesService.getMovieReviews(movieId, page, language) }
            .items.toEntity()
    }

    override suspend fun getMoviesWatchlist(
        accountId: Int,
        language: String?,
        page: Int?,
        sortBy: String?
    ): List<MovieEntity> {
        return wrapApiCall { moviesService.getMoviesWatchlist(accountId, language, page, sortBy) }
            .items.toEntity()
    }

    override suspend fun getFavoriteMovies(
        accountId: Int,
        language: String?,
        page: Int?,
        sortBy: String?
    ): List<MovieEntity> {
        return wrapApiCall { moviesService.getFavoriteMovies(accountId, language, page, sortBy) }
            .items.toEntity()
    }

    override suspend fun search(
        query: String,
        includeAdult: Boolean,
        language: String?,
        page: Int?
    ): List<MovieEntity> {
        return wrapApiCall { moviesService.search(query, includeAdult, language, page) }
            .items.toEntity()
    }

    override suspend fun getMoviesByKeyword(
        keywordId: Int,
        includeAdult: Boolean,
        language: String?,
        page: Int?,
        region: String?
    ): List<MovieEntity> {
        return wrapApiCall {
            moviesService.getMoviesByKeyword(
                keywordId,
                includeAdult,
                language,
                page,
                region
            )
        }
            .items.toEntity()
    }

    override suspend fun discoverMovies(
        includeAdult: Boolean,
        language: String?,
        page: Int?,
        sortBy: String?,
        voteAverageGte: Double?,
        year: Int?
    ): List<MovieEntity> {
        return wrapApiCall {
            moviesService.discoverMovies(
                includeAdult,
                language,
                page,
                sortBy,
                voteAverageGte,
                year
            )
        }
            .items.toEntity()
    }

    override suspend fun getLocalPopularMovies(): List<MovieEntity> {
        return movieDao.getPopularMovies()
            .toPopularMoviesEntity()
    }

    override suspend fun getLocalUpcomingMovies(): List<MovieEntity> {
        return movieDao.getUpcomingMovies()
            .toUpcomingMoviesEntity()
    }

    override suspend fun getLocalNowPlayingMovies(): List<MovieEntity> {
        return movieDao.getNowPlayingMovies()
            .toNowPlayingMoviesEntity()
    }

    override suspend fun getLocalTopRatedMovies(): List<MovieEntity> {
        return movieDao.getTopRatedMovies()
            .toTopRatedMoviesEntity()
    }

    override suspend fun cachePopularMovies(movies: List<MovieEntity>) {
        movieDao.insertPopularMovies(movies.toPopularMovieDto())
    }

    override suspend fun cacheUpcomingMovies(movies: List<MovieEntity>) {
        movieDao.insertUpcomingMovies(movies.toUpComingMovieDto())
    }

    override suspend fun cacheNowPlayingMovies(movies: List<MovieEntity>) {
        movieDao.insertNowPlayingMovies(movies.toNowPlayingMovieDto())
    }

    override suspend fun cacheTopRatedMovies(movies: List<MovieEntity>) {
        movieDao.insertTopRatedMovies(movies.toTopRatedMovieDto())
    }
}