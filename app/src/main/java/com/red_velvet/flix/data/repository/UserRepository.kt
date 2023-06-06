package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.remote.dtos.account.AccountDto
import com.red_velvet.flix.domain.model.movie.Movie
import com.red_velvet.flix.domain.model.series.TVShow

interface UserRepository {

    suspend fun login(userName: String, password: String)

    suspend fun logout()

    suspend fun getAccountDetails(): AccountDto?

    suspend fun getSessionId(): String?

    suspend fun getFavoriteMovies(
        language: String? = null,
        page: Int? = null,
        sortBy: String? = null,
    ): List<Movie>

    suspend fun getFavoriteSeries(
        language: String? = null,
        page: Int? = null,
        sortBy: String? = null,
    ): List<TVShow>

    suspend fun getMoviesWatchList(
        language: String? = null,
        page: Int? = null,
        sortBy: String? = null,
    ): List<Movie>

    suspend fun getSeriesWatchList(
        language: String? = null,
        page: Int? = null,
        sortBy: String? = null,
    ): List<TVShow>

    suspend fun getCachedFavoriteMovies(): List<Movie>

    suspend fun getCachedSeriesWatchList(): List<TVShow>

    suspend fun getCachedFavoriteSeries(): List<TVShow>

    suspend fun getCachedMoviesWatchList(): List<Movie>

    suspend fun cacheFavoriteMovies(movies: List<Movie>)

    suspend fun cacheFavoriteSeries(series: List<TVShow>)

    suspend fun cacheMoviesWatchList(movies: List<Movie>)

    suspend fun cacheSeriesWatchList(series: List<TVShow>)
}
