package com.red_velvet.flix.domain.repository

import com.red_velvet.flix.data.remote.recoures.account.AccountResource

interface UserRepository {

    suspend fun login(userName: String, password: String)

    suspend fun logout()

    suspend fun getAccountDetails(): AccountResource?

    suspend fun getSessionId(): String?
}