package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.local.shared_prefs.SharedPrefs
import com.red_velvet.flix.data.remote.MoviesService
import com.red_velvet.flix.data.remote.dtos.account.AccountDto
import com.red_velvet.flix.data.remote.dtos.auth.LoginRequest
import com.red_velvet.flix.domain.utils.ExceptionHandler
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val service: MoviesService,
    private val sharedPrefs: SharedPrefs,
    private val exceptionHandler: ExceptionHandler
) : UserRepository {
    override suspend fun login(userName: String, password: String) {
        val response =
            service.validateRequestTokenWithLogin(
                LoginRequest(
                    userName,
                    password,
                    sharedPrefs.getToken()
                )
            )
        if (response.isSuccessful) {
            sharedPrefs.getToken()?.let { createSession(it) }
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun logout() {
        sharedPrefs.clearSessionId()
    }

    override suspend fun getAccountDetails(): AccountDto {
        val response = service.getAccountDetails()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getSessionId(): String? {
        return sharedPrefs.getSessionId()
    }

    private suspend fun saveSessionId(sessionId: String) {
        sharedPrefs.setSessionId(sessionId)
    }

    private suspend fun createSession(requestToken: String) {
        val response = service.createSession(requestToken)
        if (response.isSuccessful) {
            sharedPrefs.setSessionId(response.body()?.sessionId!!)
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    private suspend fun refreshRequestToken() {
        val response = service.getRequestToken()
        if (response.isSuccessful) {
            sharedPrefs.setToken(response.body()?.requestToken!!)
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

}