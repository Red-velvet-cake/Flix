package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.local.sharedPrefs.SharedPrefs
import com.red_velvet.flix.data.remote.MoviesService
import com.red_velvet.flix.data.remote.dtos.account.AccountDto
import com.red_velvet.flix.data.remote.dtos.auth.LoginRequest
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val service: MoviesService,
    private val sharedPrefs: SharedPrefs,
) : UserRepository {
    override suspend fun login(userName: String, password: String) {
            val validateRequestTokenWithLogin =
                service.validateRequestTokenWithLogin(
                    LoginRequest(
                        userName,
                        password,
                        sharedPrefs.getToken()
                    )
                )
            if (validateRequestTokenWithLogin.isSuccessful) {
               sharedPrefs.getToken()?.let { createSession(it) }
            } else {
                throw Throwable(validateRequestTokenWithLogin.message())
            }
    }

    override suspend fun logout() {
        sharedPrefs.clearSessionId()
    }

    override suspend fun getAccountDetails(): AccountDto? {
        return service.getAccountDetails().body()
    }

    override suspend fun getSessionId(): String? {
        return sharedPrefs.getSessionId()
    }

    private suspend fun saveSessionId(sessionId: String) {
        sharedPrefs.setSessionId(sessionId)
    }

    private suspend fun createSession(requestToken: String) {
        val sessionResponse = service.createSession(requestToken)
        if (sessionResponse.isSuccessful) {
            sharedPrefs.setSessionId(sessionResponse.body()?.sessionId!!)
        } else {
            throw Exception(sessionResponse.message())
        }
    }

    private suspend fun refreshRequestToken() {
        val tokenResponse = service.getRequestToken()
        if (tokenResponse.isSuccessful) {
            sharedPrefs.setToken(tokenResponse.body()?.requestToken!!)
        } else {
            throw Exception(tokenResponse.message())
        }
    }

}