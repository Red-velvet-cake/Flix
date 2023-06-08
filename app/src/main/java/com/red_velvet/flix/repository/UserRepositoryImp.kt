package com.red_velvet.flix.repository

import com.red_velvet.flix.data.local.shared_prefs.SharedPrefs
import com.red_velvet.flix.data.remote.recoures.account.AddToWatchListRequest
import com.red_velvet.flix.data.remote.recoures.account.MarkAsFavoriteRequest
import com.red_velvet.flix.data.remote.recoures.list.CreateListRequest
import com.red_velvet.flix.domain.entity.account.AccountEntity
import com.red_velvet.flix.domain.entity.account.CustomListDetailsEntity
import com.red_velvet.flix.domain.entity.account.LoginBodyEntity
import com.red_velvet.flix.domain.entity.account.TokenEntity
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.repository.UserRepository
import com.red_velvet.flix.repository.mapper.account.toEntity
import com.red_velvet.flix.repository.mapper.account.toResource
import com.red_velvet.flix.repository.mapper.movie.toEntity
import com.red_velvet.flix.repository.mapper.series.toEntity
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val sharedPrefs: SharedPrefs,
) : UserRepository {

    override suspend fun getRequestToken(): TokenEntity {
        return remoteDataSource.getRequestToken().toEntity()
    }

    override suspend fun login(loginRequest: LoginBodyEntity): TokenEntity {
        return remoteDataSource.validateRequestTokenWithLogin(loginRequest.toResource()).toEntity()
    }

    override suspend fun createSession(requestToken: String): String {
        return remoteDataSource.createSession(requestToken).sessionId ?: ""
    }

    override suspend fun createGuestSession(): String {
        return remoteDataSource.createGuestSession().guestSessionId ?: ""
    }

    override suspend fun deleteSession(sessionId: String) {
        remoteDataSource.deleteSession(sessionId)
    }

    override suspend fun createList(createListRequest: CreateListRequest): Int {
        return remoteDataSource.createList(createListRequest).listId ?: 0
    }

    override suspend fun deleteList(listId: Int) {
        remoteDataSource.deleteList(listId)
    }

    override suspend fun clearList(listId: Int) {
        remoteDataSource.clearList(listId)
    }

    override suspend fun getListDetails(listId: Int): CustomListDetailsEntity {
        return remoteDataSource.getListDetails(listId).toEntity()
    }

    override suspend fun addItemsToList(listId: Int, mediaId: Int) {
        remoteDataSource.addItemsToList(listId, mediaId)
    }

    override suspend fun removeItemsFromList(listId: Int, mediaId: Int) {
        remoteDataSource.removeItemsFromList(listId, mediaId)
    }

    override suspend fun getAccountDetails(): AccountEntity {
        return remoteDataSource.getAccountDetails().toEntity()
    }

    override suspend fun markAsFavorite(requestBody: MarkAsFavoriteRequest) {
        remoteDataSource.markAsFavorite(requestBody)
    }

    override suspend fun getFavoriteSeries(page: Int?): List<SeriesEntity> {
        return remoteDataSource.getFavoriteSeries(page).toEntity()
    }

    override suspend fun getFavoriteMovies(page: Int?): List<MovieEntity> {
        return remoteDataSource.getFavoriteMovies(page).toEntity()
    }

    override suspend fun addToWatchlist(requestBody: AddToWatchListRequest) {
        remoteDataSource.addToWatchlist(requestBody)
    }

    override suspend fun getSeriesWatchlist(page: Int?): List<SeriesEntity> {
        return remoteDataSource.getSeriesWatchlist(page).toEntity()
    }

    override suspend fun getMoviesWatchlist(page: Int?): List<MovieEntity> {
        return remoteDataSource.getMoviesWatchlist(page).toEntity()
    }

    override suspend fun storeSessionId(sessionId: String) {
        sharedPrefs.setSessionId(sessionId)
    }

    override suspend fun storeRequestToken(requestToken: String) {
        sharedPrefs.setToken(requestToken)
    }

    override suspend fun getStoredSessionId(): String? {
        return sharedPrefs.getSessionId()
    }

    override suspend fun getStoredRequestToken(): String? {
        return sharedPrefs.getToken()
    }

}