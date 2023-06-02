package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.DataClassParser
import com.red_velvet.flix.data.local.sharedPrefs.SharedPrefs
import com.red_velvet.flix.data.remote.MoviesService
import com.red_velvet.flix.data.remote.dtos.ApiResponse
import com.red_velvet.flix.data.remote.dtos.account.AccountDto
import com.red_velvet.flix.data.remote.dtos.auth.LoginRequest
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val service: MoviesService,
    private val sharedPrefs: SharedPrefs,
    private val dataClassParser: DataClassParser
) : UserRepository {
    override suspend fun login(userName: String, password: String): Boolean? {
        return try {
            val validateRequestTokenWithLogin =
                service.validateRequestTokenWithLogin(
                    LoginRequest(
                        userName,
                        password,
                        requestToken = null
                    )
                )
            if (validateRequestTokenWithLogin.isSuccessful) {
                validateRequestTokenWithLogin.body()?.requestToken?.let { createSession(it) }
                true
            } else {
                val errorResponse = dataClassParser.parseFromJson(
                    validateRequestTokenWithLogin.errorBody()?.string(), ApiResponse::class.java
                )
                throw Throwable(errorResponse.statusMessage)
            }

        } catch (e: Exception) {
            throw Throwable(e)
        }
    }

    override suspend fun logout() {
        sharedPrefs.getToken()
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
        val sessionResponse = service.createSession(requestToken).body()
        if (sessionResponse?.success == true) {
            saveSessionId(sessionResponse.sessionId.toString())
        }
    }

    private suspend fun getRequestToken(): String {
        val tokenResponse = service.getRequestToken()
        return tokenResponse.body()?.requestToken.toString()
    }

}