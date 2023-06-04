package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.local.database.dao.MovieDao
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieEntity
import com.red_velvet.flix.data.local.database.entity.PopularMovieEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieEntity
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieEntity
import com.red_velvet.flix.data.remote.MoviesService
import com.red_velvet.flix.data.remote.dtos.movie.KeywordsDto
import com.red_velvet.flix.data.remote.dtos.movie.MovieDto
import com.red_velvet.flix.data.remote.dtos.review.ReviewDto
import com.red_velvet.flix.data.remote.dtos.trailer.TrailersDto
import com.red_velvet.flix.domain.mapper.movie.toNowPlayingMovieEntityList
import com.red_velvet.flix.domain.mapper.movie.toPopularMovieEntityList
import com.red_velvet.flix.domain.mapper.movie.toTopRatedMovieEntityList
import com.red_velvet.flix.domain.mapper.movie.toUpcomingMovieEntityList
import com.red_velvet.flix.domain.utils.ExceptionHandler
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val moviesService: MoviesService,
    private val movieDao: MovieDao,
    private val exceptionHandler: ExceptionHandler
) : MovieRepository {

    override fun getPopularMovies(
        page: Int?, region: String?, language: String?
    ): Flow<List<PopularMovieEntity>> {
        return movieDao.getPopularMovies()
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
    ): Flow<List<UpcomingMovieEntity>> {
        return movieDao.getUpcomingMovies()
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
    ): Flow<List<NowPlayingMovieEntity>> {
        return movieDao.getNowPlayingMovies()
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
    ): Flow<List<TopRatedMovieEntity>> {
        return movieDao.getTopRatedMovies()
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

    override suspend fun getMovieDetails(movieId: Int): MovieDto {
        val response = moviesService.getMovieDetails(movieId)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }


    override suspend fun getMovieKeywords(movieId: Int): KeywordsDto {
        val response = moviesService.getMovieKeywords(movieId)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getSimilarMovies(
        movieId: Int,
        page: Int?,
        language: String?
    ): List<MovieDto> {
        val response = moviesService.getSimilarMovies(movieId, page, language)
        if (response.isSuccessful) {
            return response.body()?.items!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getMovieTrailers(movieId: Int, language: String?): TrailersDto {
        val response = moviesService.getMovieTrailers(movieId, language)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getLatestMovie(): MovieDto {
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
    ): List<MovieDto> {
        val response = moviesService.getMovieRecommendations(movieId, page, language)
        if (response.isSuccessful) {
            return response.body()?.items!!
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
    ): List<ReviewDto> {
        val response = moviesService.getMovieReviews(movieId, page, language)
        if (response.isSuccessful) {
            return response.body()?.items!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getMoviesWatchlist(
        accountId: Int,
        language: String?,
        page: Int?,
        sortBy: String?
    ): List<MovieDto> {
        val response = moviesService.getMoviesWatchlist(accountId, language, page, sortBy)
        if (response.isSuccessful) {
            return response.body()?.items!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getFavoriteMovies(
        accountId: Int,
        language: String?,
        page: Int?,
        sortBy: String?
    ): List<MovieDto> {
        val response = moviesService.getFavoriteMovies(accountId, language, page, sortBy)
        if (response.isSuccessful) {
            return response.body()?.items!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun search(
        query: String,
        includeAdult: Boolean,
        language: String?,
        page: Int?
    ): List<MovieDto> {
        val response = moviesService.search(query, includeAdult, language, page)
        if (response.isSuccessful) {
            return response.body()?.items!!
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
    ): List<MovieDto> {
        val response = moviesService.getMoviesByKeyword(
            keywordId,
            includeAdult,
            language,
            page,
            region
        )
        if (response.isSuccessful) {
            return response.body()?.items!!
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
    ): List<MovieDto> {
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
            return response.body()?.items!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

}