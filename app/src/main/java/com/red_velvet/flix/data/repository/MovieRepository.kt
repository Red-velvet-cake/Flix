package com.red_velvet.flix.data.repository


import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieEntity
import com.red_velvet.flix.data.local.database.entity.PopularMovieEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieEntity
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieEntity
import com.red_velvet.flix.data.remote.dtos.movie.KeywordsDto
import com.red_velvet.flix.data.remote.dtos.movie.MovieDto
import com.red_velvet.flix.data.remote.dtos.review.ReviewDto
import com.red_velvet.flix.data.remote.dtos.trailer.TrailersDto
import kotlinx.coroutines.flow.Flow


interface MovieRepository {

    fun getPopularMovies(
        page: Int = 1,
        region: String? = null,
        language: String? = null
    ): Flow<List<PopularMovieEntity>>

    fun getUpcomingMovies(
        page: Int = 1,
        region: String? = null,
        language: String? = null
    ): Flow<List<UpcomingMovieEntity>>

    fun getNowPlayingMovies(
        page: Int = 1,
        region: String? = null,
        language: String? = null
    ): Flow<List<NowPlayingMovieEntity>>

    fun getTopRatedMovies(
        page: Int = 1,
        region: String? = null,
        language: String? = null
    ): Flow<List<TopRatedMovieEntity>>

    suspend fun getMovieDetails(movieId: Int): MovieDto

    suspend fun getMovieKeywords(movieId: Int): KeywordsDto

    suspend fun getSimilarMovies(
        movieId: Int,
        page: Int = 1,
        language: String? = null
    ): List<MovieDto>

    suspend fun getMovieTrailers(
        movieId: Int,
        language: String? = null
    ): TrailersDto

    suspend fun getLatestMovie(): List<MovieDto>

    suspend fun getMovieRecommendations(
        movieId: Int,
        page: Int = 1,
        language: String? = null
    ): List<MovieDto>

    suspend fun rateMovie(movieId: Int, rating: Double)

    suspend fun deleteMovieRating(movieId: Int)

    suspend fun getMovieReviews(
        movieId: Int,
        page: Int = 1,
        language: String? = null
    ): List<ReviewDto>

    suspend fun getMoviesWatchlist(
        accountId: Int,
        language: String? = null,
        page: Int = 1,
        sortBy: String? = null
    ): List<MovieDto>

    suspend fun getFavoriteMovies(
        accountId: Int,
        language: String? = null,
        page: Int = 1,
        sortBy: String? = null
    ): List<MovieDto>

    suspend fun search(
        query: String,
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int = 1,
    ): List<MovieDto>

    suspend fun getMoviesByKeyword(
        keywordId: Int,
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int = 1,
        region: String? = null
    ): List<MovieDto>

    suspend fun discoverMovies(
        includeAdult: Boolean = false,
        includeVideo: Boolean,
        language: String? = null,
        page: Int = 1,
        primaryReleaseYear: Int? = null,
        primaryReleaseDateGte: String? = null,
        primaryReleaseDateLte: String? = null,
        region: String? = null,
        releaseDateGte: String? = null,
        releaseDateLte: String? = null,
        sortBy: String,
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