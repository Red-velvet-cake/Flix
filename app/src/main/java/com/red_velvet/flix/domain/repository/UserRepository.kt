package com.red_velvet.flix.domain.repository

import com.red_velvet.flix.domain.entity.account.AccountEntity

interface UserRepository {

    suspend fun login(userName: String, password: String)

    suspend fun logout()

    suspend fun getAccountDetails(): AccountEntity

    suspend fun getSessionId(): String?
}