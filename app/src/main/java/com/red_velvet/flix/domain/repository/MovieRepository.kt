package com.red_velvet.flix.domain.repository


import com.red_velvet.flix.data.remote.recoures.movie.MovieResource
import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.entity.TrailerEntity
import com.red_velvet.flix.domain.entity.movie.MovieEntity


interface MovieRepository {

    suspend fun getPopularMovies(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): List<MovieEntity>

    suspend fun refreshPopularMovies()

    suspend fun getUpcomingMovies(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): List<MovieEntity>

    suspend fun refreshUpcomingMovies()

    suspend fun getNowPlayingMovies(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): List<MovieEntity>

    suspend fun refreshNowPlayingMovies()

    suspend fun getTopRatedMovies(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): List<MovieEntity>

    suspend fun refreshTopRatedMovies()

    suspend fun getMovieDetails(movieId: Int): MovieEntity


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

    suspend fun getLatestMovie(): MovieResource

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
        includeVideo: Boolean,
        language: String? = null,
        page: Int? = null,
        primaryReleaseYear: Int? = null,
        primaryReleaseDateGte: String? = null,
        primaryReleaseDateLte: String? = null,
        region: String? = null,
        releaseDateGte: String? = null,
        releaseDateLte: String? = null,
        sortBy: String? = null,
        voteAverageGte: Double? = null,
        voteAverageLte: Double? = null,
        voteCountGte: Int? = null,
        voteCountLte: Int? = null,
        watchRegion: String? = null,
        withCast: String? = null,
        withCrew: String? = null,
        withGenres: String? = null,
        withKeywords: String? = null,
        withOriginCountry: String? = null,
        withOriginalLanguage: String? = null,
        withPeople: String? = null,
        withReleaseType: Int? = null,
        withRuntimeGte: Int? = null,
        withRuntimeLte: Int? = null,
        withWatchMonetizationTypes: String? = null,
        withWatchProviders: String? = null,
        withoutGenres: String? = null,
        withoutKeywords: String? = null,
        withoutWatchProviders: String? = null,
        withoutCompanies: String? = null,
        year: Int? = null
    ): List<MovieEntity>
}