package com.red_velvet.flix.data.repository


import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieEntity
import com.red_velvet.flix.data.local.database.entity.PopularMovieEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieEntity
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieEntity
import com.red_velvet.flix.data.remote.dtos.PaginationDto
import com.red_velvet.flix.data.remote.dtos.movie.KeywordsDto
import com.red_velvet.flix.data.remote.dtos.movie.MovieDetailsDto
import com.red_velvet.flix.data.remote.dtos.movie.MovieDto
import com.red_velvet.flix.data.remote.dtos.review.ReviewDto
import com.red_velvet.flix.data.remote.dtos.trailer.TrailersDto
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieRepository {

    suspend fun insertPopularMovie()

    suspend fun insertTopRatedMovie()

    suspend fun insertUpcomingMovie()

    suspend fun insertNowPlayingMovie()

    suspend fun getPopularMovies(
        page: Int,
        region: String?,
        language: String
    ): Flow<List<PopularMovieEntity>>

    suspend fun getUpcomingMovies(
        page: Int,
        region: String?,
        language: String
    ): Flow<List<UpcomingMovieEntity>>

    suspend fun getNowPlayingMovies(
        page: Int,
        region: String?,
        language: String
    ): Flow<List<NowPlayingMovieEntity>>

    suspend fun getTopRatedMovies(
        page: Int = 1,
        region: String?,
        language: String
    ): Flow<List<TopRatedMovieEntity>>

    suspend fun getMovieDetails(movieId: Int): List<MovieDetailsDto>?

    suspend fun getLatestMovie(movieId: Int): List<MovieDto>?

    suspend fun getMovieKeywords(movieId: Int): List<KeywordsDto>?

    suspend fun getSimilarMovies(
        movieId: Int,
        page: Int,
        language: String
    ): List<MovieDto>?

    suspend fun getMovieTrailers(movieId: Int, language: String): List<TrailersDto>?

    suspend fun getLatestMovie(): List<MovieDto>?

    suspend fun getMovieRecommendations(
        movieId: Int,
        page: Int = 1,
        language: String
    ): List<MovieDto>?

    suspend fun rateMovie(movieId: Int, rating: Double)

    suspend fun deleteMovieRating(movieId: Int)

    suspend fun getMovieReviews(
        movieId: Int,
        page: Int,
        language: String
    ): List<ReviewDto>?

    suspend fun getMoviesWatchlist(
        accountId: Int,
        language: String,
        page: Int,
        sortBy: String
    ): List<MovieDto>?

    suspend fun getFavoriteMovies(
        accountId: Int,
        language: String,
        page: Int,
        sortBy: String
    ): List<MovieDto>?

    suspend fun search(
        query: String,
        includeAdult: Boolean,
        language: String,
        page: Int,
    ): List<MovieDto>?

    @GET("search/movie")
    suspend fun searchMovies(
        query: String,
        includeAdult: Boolean,
        language: String,
        primaryReleaseYear: Int?,
        page: Int,
        region: String?,
        year: Int?
    ): List<MovieDto>?

    suspend fun getMoviesByKeyword(
        keywordId: Int,
        includeAdult: Boolean = false,
        language: String = "en-US",
        page: Int = 1,
        region: String? = null
    ): List<MovieDto>?

    suspend fun discoverMovies(
        includeAdult: Boolean,
        includeVideo: Boolean,
        language: String,
        page: Int,
        primaryReleaseYear: Int?,
        primaryReleaseDateGte: String?,
        primaryReleaseDateLte: String?,
        region: String?,
        releaseDateGte: String?,
        releaseDateLte: String?,
        sortBy: String,
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
    ): List<MovieDto>?
}