package com.red_velvet.flix.domain.repository


import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.entity.TrailerEntity
import com.red_velvet.flix.domain.entity.movie.MovieCastEntity
import com.red_velvet.flix.domain.entity.movie.MovieDetailsEntity
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.entity.movie.MovieImagesEntity


interface MovieRepository {

    suspend fun getPopularMovies(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): List<MovieEntity>

    suspend fun getUpcomingMovies(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): List<MovieEntity>

    suspend fun getNowPlayingMovies(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): List<MovieEntity>

    suspend fun getTopRatedMovies(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): List<MovieEntity>

    suspend fun getMovieDetails(movieId: Int): MovieDetailsEntity

    suspend fun getMovieKeywords(movieId: Int): List<String>

    suspend fun getSimilarMovies(
        movieId: Int,
        page: Int? = null,
        language: String? = null
    ): List<MovieEntity>

    suspend fun getMovieTrailers(
        movieId: Int,
        language: String? = null
    ): List<TrailerEntity>

    suspend fun getLatestMovie(): MovieEntity

    suspend fun getMovieRecommendations(
        movieId: Int,
        page: Int? = null,
        language: String? = null
    ): List<MovieEntity>

    suspend fun rateMovie(movieId: Int, rating: Double)

    suspend fun deleteMovieRating(movieId: Int)

    suspend fun getMovieReviews(
        movieId: Int,
        page: Int? = null,
        language: String? = null
    ): List<ReviewEntity>

    suspend fun getMoviesWatchlist(
        accountId: Int,
        language: String? = null,
        page: Int? = null,
        sortBy: String? = null
    ): List<MovieEntity>

    suspend fun getFavoriteMovies(
        accountId: Int,
        language: String? = null,
        page: Int? = null,
        sortBy: String? = null
    ): List<MovieEntity>

    suspend fun search(
        query: String,
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int? = null,
    ): List<MovieEntity>

    suspend fun getMoviesByKeyword(
        keywordId: Int,
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int? = null,
        region: String? = null
    ): List<MovieEntity>

    suspend fun discoverMovies(
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int? = null,
        sortBy: String? = null,
        voteAverageGte: Double? = null,
        year: Int? = null,
    ): List<MovieEntity>
    suspend fun getMovieCredits(movieId: Int):List<MovieCastEntity>

    suspend fun getMovieImages(movieId: Int):MovieImagesEntity

    suspend fun getLocalPopularMovies(): List<MovieEntity>

    suspend fun getLocalUpcomingMovies(): List<MovieEntity>

    suspend fun getLocalNowPlayingMovies(): List<MovieEntity>

    suspend fun getLocalTopRatedMovies(): List<MovieEntity>

    suspend fun cachePopularMovies(movies: List<MovieEntity>)

    suspend fun cacheUpcomingMovies(movies: List<MovieEntity>)

    suspend fun cacheNowPlayingMovies(movies: List<MovieEntity>)

    suspend fun cacheTopRatedMovies(movies: List<MovieEntity>)
}