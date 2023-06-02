package com.red_velvet.flix.data.repository


import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieEntity
import com.red_velvet.flix.data.local.database.entity.PopularMovieEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieEntity
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieEntity
import com.red_velvet.flix.data.remote.dtos.ApiResponse
import com.red_velvet.flix.data.remote.dtos.movie.KeywordsDto
import com.red_velvet.flix.data.remote.dtos.movie.MovieDto
import com.red_velvet.flix.data.remote.dtos.review.ReviewDto
import com.red_velvet.flix.data.remote.dtos.trailer.TrailersDto
import kotlinx.coroutines.flow.Flow


interface MovieRepository {

    fun getPopularMovies(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): Flow<List<PopularMovieEntity>>

    suspend fun refreshPopularMovies()

    fun getUpcomingMovies(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): Flow<List<UpcomingMovieEntity>>

    suspend fun refreshUpcomingMovies()

    fun getNowPlayingMovies(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): Flow<List<NowPlayingMovieEntity>>

    suspend fun refreshNowPlayingMovies()

    fun getTopRatedMovies(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): Flow<List<TopRatedMovieEntity>>

    suspend fun refreshTopRatedMovies()

    suspend fun getMovieDetails(movieId: Int): MovieDto


    suspend fun getMovieKeywords(movieId: Int): KeywordsDto

    suspend fun getSimilarMovies(
        movieId: Int,
        page: Int? = null,
        language: String? = null
    ): List<MovieDto>

    suspend fun getMovieTrailers(
        movieId: Int,
        language: String? = null
    ): TrailersDto

    suspend fun getLatestMovie(): MovieDto

    suspend fun getMovieRecommendations(
        movieId: Int,
        page: Int? = null,
        language: String? = null
    ): List<MovieDto>

    suspend fun rateMovie(movieId: Int, rating: Double)

    suspend fun deleteMovieRating(movieId: Int): ApiResponse

    suspend fun getMovieReviews(
        movieId: Int,
        page: Int? = null,
        language: String? = null
    ): List<ReviewDto>

    suspend fun getMoviesWatchlist(
        accountId: Int,
        language: String? = null,
        page: Int? = null,
        sortBy: String? = null
    ): List<MovieDto>

    suspend fun getFavoriteMovies(
        accountId: Int,
        language: String? = null,
        page: Int? = null,
        sortBy: String? = null
    ): List<MovieDto>

    suspend fun search(
        query: String,
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int? = null,
    ): List<MovieDto>

    suspend fun getMoviesByKeyword(
        keywordId: Int,
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int? = null,
        region: String? = null
    ): List<MovieDto>

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
    ): List<MovieDto>
}