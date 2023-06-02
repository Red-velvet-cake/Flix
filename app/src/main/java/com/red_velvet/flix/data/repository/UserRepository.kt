package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.remote.dtos.account.AccountDto

interface UserRepository {

    suspend fun login(userName: String, password: String)

    suspend fun logout()

    suspend fun getAccountDetails(): AccountDto?

    suspend fun getSessionId(): String?
}