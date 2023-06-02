package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.local.database.dao.MovieDao
import com.red_velvet.flix.data.local.database.entity.MovieDetailEntity
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
import com.red_velvet.flix.domain.mapper.movie.toNowPlayingMovieEntity
import com.red_velvet.flix.domain.mapper.movie.toPopularMovieEntity
import com.red_velvet.flix.domain.mapper.movie.toTopRatedMovieEntity
import com.red_velvet.flix.domain.mapper.movie.toUpcomingMovieEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val moviesService: MoviesService,
    private val movieDao: MovieDao,
) : MovieRepository, BaseRepository() {

    override fun getPopularMovies(
        page: Int, region: String?, language: String?
    ): Flow<List<PopularMovieEntity>> {
        return movieDao.getPopularMovies()
    }

    override suspend fun refreshPopularMovies() {
        moviesService.getPopularMovies().let { popularMoviesResponse ->
            if (popularMoviesResponse.isSuccessful) {
                popularMoviesResponse.body()?.items?.map {
                    it.toPopularMovieEntity()
                }.let {
                    movieDao.insertPopularMovies(it!!)
                }
            }
        }
    }


    override fun getUpcomingMovies(
        page: Int, region: String?, language: String?
    ): Flow<List<UpcomingMovieEntity>> {
        return movieDao.getUpcomingMovies()
    }

    override suspend fun refreshUpcomingMovies() {
        moviesService.getUpcomingMovies().let { upcomingMoviesResponse ->
            if (upcomingMoviesResponse.isSuccessful) {

                upcomingMoviesResponse.body()?.items?.map {
                    it.toUpcomingMovieEntity()
                }.let {
                    movieDao.insertUpcomingMovies(it!!)
                }
            }
        }
    }


    override fun getNowPlayingMovies(
        page: Int, region: String?, language: String?
    ): Flow<List<NowPlayingMovieEntity>> {
        return movieDao.getNowPlayingMovies()
    }

    override suspend fun refreshNowPlayingMovies() {
        moviesService.getUpcomingMovies().let { nowPlayingMoviesResponse ->
            if (nowPlayingMoviesResponse.isSuccessful) {
                nowPlayingMoviesResponse.body()?.items?.map {
                    it.toNowPlayingMovieEntity()
                }.let {
                    movieDao.insertNowPlayingMovies(it!!)
                }
            }
        }
    }

    override fun getTopRatedMovies(
        page: Int, region: String?, language: String?
    ): Flow<List<TopRatedMovieEntity>> {
        return movieDao.getTopRatedMovies()
    }

    override suspend fun refreshTopRatedMovies() {
        moviesService.getUpcomingMovies().let { topRatedMoviesResponse ->
            if (topRatedMoviesResponse.isSuccessful) {
                topRatedMoviesResponse.body()?.items?.map {
                    it.toTopRatedMovieEntity()
                }.let {
                    movieDao.insertTopRatedMovies(it!!)
                }
            }
        }
    }

    override suspend fun getMovieDetails(movieId: Int): Flow<List<MovieDetailEntity>> {

    }

    override suspend fun refreshMovieDetails() {
        moviesService.getUpcomingMovies().let { movieDetailsResponse ->
            if (movieDetailsResponse.isSuccessful) {
                movieDetailsResponse.body()?.items?.map {
                    it.toMove()
                }.let {
                    movieDao.insertTopRatedMovies(it!!)
                }
            }
        }

    }

    override suspend fun getMovieKeywords(movieId: Int): KeywordsDto {
        return moviesService.getMovieKeywords(movieId).body()!!
    }

    override suspend fun getSimilarMovies(
        movieId: Int, page: Int, language: String
    ): List<MovieDto> {
        return moviesService.getSimilarMovies(movieId, page, language).body()?.items!!
    }

    override suspend fun getMovieTrailers(movieId: Int, language: String): TrailersDto {
        return moviesService.getMovieTrailers(movieId, language).body()!!
    }

    override suspend fun getLatestMovie(): MovieDto {
        return moviesService.getLatestMovie().body()!!
    }

    override suspend fun getMovieRecommendations(
        movieId: Int, page: Int, language: String
    ): List<MovieDto> {
        return moviesService.getMovieRecommendations(movieId, page, language).body()?.items!!
    }

    override suspend fun rateMovie(movieId: Int, rating: Double): ApiResponse {
        return moviesService.rateMovie(movieId, rating).body()!!
    }

    override suspend fun deleteMovieRating(movieId: Int): ApiResponse {
        return moviesService.deleteMovieRating(movieId).body()!!
    }

    override suspend fun getMovieReviews(
        movieId: Int, page: Int, language: String
    ): List<ReviewDto> {
        return moviesService.getMovieReviews(movieId, page, language).body()?.items!!
    }

    override suspend fun getMoviesWatchlist(
        accountId: Int, language: String, page: Int, sortBy: String
    ): List<MovieDto> {
        return moviesService.getMoviesWatchlist(
            accountId, language, page, sortBy
        ).body()?.items!!
    }

    override suspend fun getFavoriteMovies(
        accountId: Int, language: String, page: Int, sortBy: String
    ): List<MovieDto> {
        return moviesService.getFavoriteMovies(
            accountId, language, page, sortBy
        ).body()?.items!!
    }

    override suspend fun search(
        query: String, includeAdult: Boolean, language: String, page: Int
    ): List<MovieDto> {
        return moviesService.search(
            query, includeAdult, language, page
        ).body()?.items!!
    }

    override suspend fun getMoviesByKeyword(
        keywordId: Int, includeAdult: Boolean, language: String, page: Int, region: String?
    ): List<MovieDto> {
        return moviesService.getMoviesByKeyword(
            keywordId,
            includeAdult,
            language,
            page,
        ).body()?.items!!
    }

    override suspend fun discoverMovies(
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
    ): List<MovieDto> {
        return moviesService.discoverMovies(
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
        ).body()?.items!!
    }

}