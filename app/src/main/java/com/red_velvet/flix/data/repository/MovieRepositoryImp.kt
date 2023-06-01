package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.local.database.dao.MovieDao
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieEntity
import com.red_velvet.flix.data.local.database.entity.PopularMovieEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieEntity
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieEntity
import com.red_velvet.flix.data.remote.MoviesService
import com.red_velvet.flix.data.remote.dtos.ApiResponse
import com.red_velvet.flix.data.remote.dtos.movie.KeywordsDto
import com.red_velvet.flix.data.remote.dtos.movie.MovieDto
import com.red_velvet.flix.data.remote.dtos.review.ReviewDto
import com.red_velvet.flix.data.remote.dtos.trailer.TrailersDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val moviesService: MoviesService,
    private val movieDao: MovieDao,
) : MovieRepository, BaseRepository() {
    override fun getPopularMovies(
        page: Int,
        region: String?,
        language: String?
    ): Flow<List<PopularMovieEntity>> {
        TODO("Not yet implemented")
    }

    override fun getUpcomingMovies(
        page: Int,
        region: String?,
        language: String?
    ): Flow<List<UpcomingMovieEntity>> {
        TODO("Not yet implemented")
    }

    override fun getNowPlayingMovies(
        page: Int,
        region: String?,
        language: String?
    ): Flow<List<NowPlayingMovieEntity>> {
        TODO("Not yet implemented")
    }

    override fun getTopRatedMovies(
        page: Int,
        region: String?,
        language: String?
    ): Flow<List<TopRatedMovieEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDto {
       return moviesService.getMovieDetails(movieId).body()!!
    }

    override suspend fun getMovieKeywords(movieId: Int): KeywordsDto {
        return moviesService.getMovieKeywords(movieId).body()!!
    }

    override suspend fun getSimilarMovies(
        movieId: Int,
        page: Int,
        language: String?
    ): List<MovieDto> {
       return moviesService.getSimilarMovies(movieId).body()?.items!!
    }

    override suspend fun getMovieTrailers(movieId: Int, language: String?): TrailersDto {
        return moviesService.getMovieTrailers(movieId).body()!!
    }

    override suspend fun getLatestMovie(): MovieDto {
        return moviesService.getLatestMovie().body()!!
    }

    override suspend fun getMovieRecommendations(
        movieId: Int,
        page: Int,
        language: String?
    ): List<MovieDto> {
        return moviesService.getMovieRecommendations(movieId).body()?.items!!
    }

    override suspend fun rateMovie(movieId: Int, rating: Double):ApiResponse {
        return moviesService.rateMovie(movieId, rating).body()!!
    }

    override suspend fun deleteMovieRating(movieId: Int): ApiResponse {
        return moviesService.deleteMovieRating(movieId).body()!!
    }

    override suspend fun getMovieReviews(
        movieId: Int,
        page: Int,
        language: String?
    ): List<ReviewDto> {
        return moviesService.getMovieReviews(movieId, page).body()?.items!!
    }

    override suspend fun getMoviesWatchlist(
        accountId: Int,
        language: String?,
        page: Int,
        sortBy: String?
    ): List<MovieDto> {
        return moviesService.getMoviesWatchlist(accountId).body()?.items!!
    }

    override suspend fun getFavoriteMovies(
        accountId: Int,
        language: String?,
        page: Int,
        sortBy: String?
    ): List<MovieDto> {
       return moviesService.getFavoriteMovies(accountId).body()?.items!!
    }

    override suspend fun search(
        query: String,
        includeAdult: Boolean,
        language: String?,
        page: Int
    ): List<MovieDto> {
        return moviesService.search(query, includeAdult).body()?.items!!
    }

    override suspend fun getMoviesByKeyword(
        keywordId: Int,
        includeAdult: Boolean,
        language: String?,
        page: Int,
        region: String?
    ): List<MovieDto> {
        return moviesService.getMoviesByKeyword(keywordId).body()?.items!!
    }

    override suspend fun discoverMovies(
        includeAdult: Boolean,
        includeVideo: Boolean,
        language: String?,
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
    ): List<MovieDto> {
       return moviesService.discoverMovies(includeAdult, includeVideo).body()?.items!!
    }

}