package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.local.shared_prefs.SharedPrefs
import com.red_velvet.flix.data.remote.MoviesService
import com.red_velvet.flix.data.remote.recoures.auth.LoginRequest
import com.red_velvet.flix.data.repository.mapper.account.toEntity
import com.red_velvet.flix.data.util.ExceptionHandler
import com.red_velvet.flix.domain.entity.account.AccountEntity
import com.red_velvet.flix.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val service: MoviesService,
    private val sharedPrefs: SharedPrefs,
    exceptionHandler: ExceptionHandler
) : UserRepository, BaseRepository(exceptionHandler) {
    override suspend fun login(userName: String, password: String) {
        wrapApiCall {
            service.validateRequestTokenWithLogin(
                LoginRequest(
                    userName,
                    password,
                    sharedPrefs.getToken()
                )
            )
        }.requestToken?.let {
            createSession(it)
        }
    }

    override suspend fun logout() {
        sharedPrefs.clearSessionId()
    }

    override suspend fun getAccountDetails(): AccountEntity {
        return wrapApiCall { service.getAccountDetails() }
            .toEntity()
    }

    override suspend fun getSessionId(): String? {
        return sharedPrefs.getSessionId()
    }

    private suspend fun saveSessionId(sessionId: String) {
        sharedPrefs.setSessionId(sessionId)
    }

    private suspend fun createSession(requestToken: String) {
        wrapApiCall { service.createSession(requestToken) }
            .sessionId?.let { saveSessionId(it) }
    }

    private suspend fun generateRequestToken() {
        wrapApiCall { service.getRequestToken() }
            .requestToken?.let { sharedPrefs.setToken(it) }
    }

}