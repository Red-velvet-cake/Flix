package com.red_velvet.flix.repository

import com.red_velvet.flix.domain.entity.PersonEntity
import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.entity.TrailerEntity
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import com.red_velvet.flix.repository.mapper.movie.toEntity
import com.red_velvet.flix.repository.mapper.movie.toNowPlayingMovieDto
import com.red_velvet.flix.repository.mapper.movie.toNowPlayingMoviesEntity
import com.red_velvet.flix.repository.mapper.movie.toPopularMovieDto
import com.red_velvet.flix.repository.mapper.movie.toPopularMoviesEntity
import com.red_velvet.flix.repository.mapper.movie.toTopRatedMovieDto
import com.red_velvet.flix.repository.mapper.movie.toTopRatedMoviesEntity
import com.red_velvet.flix.repository.mapper.movie.toUpComingMovieDto
import com.red_velvet.flix.repository.mapper.movie.toUpcomingMoviesEntity
import com.red_velvet.flix.repository.mapper.series.toEntity
import com.red_velvet.flix.repository.mapper.toEntity
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : MovieRepository {
    override suspend fun getPopularMovies(page: Int?): List<MovieEntity> {
        return remoteDataSource.getPopularMovies(page).toEntity()
    }

    override suspend fun getUpcomingMovies(page: Int?): List<MovieEntity> {
        return remoteDataSource.getUpcomingMovies(page).toEntity()
    }

    override suspend fun getNowPlayingMovies(page: Int?): List<MovieEntity> {
        return remoteDataSource.getNowPlayingMovies(page).toEntity()
    }

    override suspend fun getTopRatedMovies(page: Int?): List<MovieEntity> {
        return remoteDataSource.getTopRatedMovies(page).toEntity()
    }

    override suspend fun getMovieDetails(movieId: Int): MovieEntity {
        return remoteDataSource.getMovieDetails(movieId).toEntity()
    }

    override suspend fun getMovieKeywords(movieId: Int): List<String> {
        return remoteDataSource.getMovieKeywords(movieId).toEntity()
    }

    override suspend fun getSimilarMovies(movieId: Int, page: Int?): List<MovieEntity> {
        return remoteDataSource.getSimilarMovies(movieId, page).toEntity()
    }

    override suspend fun getMovieTrailers(movieId: Int): List<TrailerEntity> {
        return remoteDataSource.getMovieTrailers(movieId).toEntity()
    }

    override suspend fun getLatestMovie(): MovieEntity {
        return remoteDataSource.getLatestMovie().toEntity()
    }

    override suspend fun getMovieRecommendations(movieId: Int, page: Int?): List<MovieEntity> {
        return remoteDataSource.getMovieRecommendations(movieId, page).toEntity()
    }

    override suspend fun rateMovie(movieId: Int, rate: Float) {
        remoteDataSource.rateMovie(movieId, rate)
    }

    override suspend fun deleteMovieRating(movieId: Int) {
        remoteDataSource.deleteMovieRating(movieId)
    }

    override suspend fun getMovieReviews(movieId: Int, page: Int?): List<ReviewEntity> {
        return remoteDataSource.getMovieReviews(movieId, page).toEntity()
    }

    override suspend fun getMoviesWatchlist(page: Int?): List<MovieEntity> {
        return remoteDataSource.getMoviesWatchlist(page).toEntity()
    }

    override suspend fun getFavoriteMovies(page: Int?): List<MovieEntity> {
        return remoteDataSource.getFavoriteMovies(page).toEntity()
    }

    override suspend fun search(query: String, page: Int?): List<MovieEntity> {
        return remoteDataSource.search(query, page).toEntity()
    }

    override suspend fun searchSeries(query: String, page: Int?): List<SeriesEntity> {
        return remoteDataSource.searchSeries(query, page).toEntity()
    }

    override suspend fun searchPeople(query: String, page: Int?): List<PersonEntity> {
        return remoteDataSource.searchPeople(query, page).items.toEntity()
    }


    override suspend fun searchMovies(query: String, page: Int?): List<MovieEntity> {
        return remoteDataSource.searchMovies(query, page).toEntity()
    }



    override suspend fun getMoviesByKeyword(keywordId: Int, page: Int?): List<MovieEntity> {
        return remoteDataSource.getMoviesByKeyword(keywordId, page).toEntity()
    }

    override suspend fun discoverMovies(
        page: Int?,
        sortBy: String?,
        rate: Float?,
        year: Int?
    ): List<MovieEntity> {
        return remoteDataSource.discoverMovies(page, sortBy, rate, year).toEntity()
    }

    override suspend fun getLocalPopularMovies(): List<MovieEntity> {
        return localDataSource.getPopularMovies()
            .toPopularMoviesEntity()
    }

    override suspend fun getLocalUpcomingMovies(): List<MovieEntity> {
        return localDataSource.getUpcomingMovies()
            .toUpcomingMoviesEntity()
    }

    override suspend fun getLocalNowPlayingMovies(): List<MovieEntity> {
        return localDataSource.getNowPlayingMovies()
            .toNowPlayingMoviesEntity()
    }

    override suspend fun getLocalTopRatedMovies(): List<MovieEntity> {
        return localDataSource.getTopRatedMovies()
            .toTopRatedMoviesEntity()
    }

    override suspend fun cachePopularMovies(movies: List<MovieEntity>) {
        localDataSource.insertPopularMovies(movies.toPopularMovieDto())
    }

    override suspend fun cacheUpcomingMovies(movies: List<MovieEntity>) {
        localDataSource.insertUpcomingMovies(movies.toUpComingMovieDto())
    }

    override suspend fun cacheNowPlayingMovies(movies: List<MovieEntity>) {
        localDataSource.insertNowPlayingMovies(movies.toNowPlayingMovieDto())
    }

    override suspend fun cacheTopRatedMovies(movies: List<MovieEntity>) {
        localDataSource.insertTopRatedMovies(movies.toTopRatedMovieDto())
    }
}