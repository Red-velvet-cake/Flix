package com.red_velvet.flix.domain.repository

import com.red_velvet.flix.data.remote.recoures.account.AddToWatchListRequest
import com.red_velvet.flix.data.remote.recoures.account.MarkAsFavoriteRequest
import com.red_velvet.flix.data.remote.recoures.list.CreateListRequest
import com.red_velvet.flix.domain.entity.account.AccountEntity
import com.red_velvet.flix.domain.entity.account.CustomListDetailsEntity
import com.red_velvet.flix.domain.entity.account.LoginBodyEntity
import com.red_velvet.flix.domain.entity.account.TokenEntity
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.entity.series.SeriesEntity

interface UserRepository {

    suspend fun getRequestToken(): TokenEntity
    suspend fun login(loginRequest: LoginBodyEntity): TokenEntity
    suspend fun createSession(requestToken: String): String
    suspend fun createGuestSession(): String
    suspend fun deleteSession(sessionId: String)
    suspend fun createList(createListRequest: CreateListRequest): Int
    suspend fun deleteList(listId: Int)
    suspend fun clearList(listId: Int)
    suspend fun getListDetails(listId: Int): CustomListDetailsEntity
    suspend fun addItemsToList(listId: Int, mediaId: Int)
    suspend fun removeItemsFromList(listId: Int, mediaId: Int)
    suspend fun getAccountDetails(): AccountEntity
    suspend fun markAsFavorite(requestBody: MarkAsFavoriteRequest)
    suspend fun getFavoriteSeries(page: Int?): List<SeriesEntity>
    suspend fun getFavoriteMovies(page: Int?): List<MovieEntity>
    suspend fun addToWatchlist(requestBody: AddToWatchListRequest)
    suspend fun getSeriesWatchlist(page: Int?): List<SeriesEntity>
    suspend fun getMoviesWatchlist(page: Int?): List<MovieEntity>

    suspend fun storeSessionId(sessionId: String)
    suspend fun storeRequestToken(requestToken: String)
    suspend fun getStoredSessionId(): String?
    suspend fun getStoredRequestToken(): String?
    suspend fun clearSession()
    suspend fun isUserLoggedIn(): Boolean
}