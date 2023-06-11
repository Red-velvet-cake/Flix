package com.red_velvet.flix.domain.usecase.login.user

import com.red_velvet.flix.domain.entity.account.LoginBodyEntity
import com.red_velvet.flix.domain.repository.UserRepository
import javax.inject.Inject

class UserLoginUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val requestTokenUseCase: RequestTokenUseCase,
    private val sessionCreationUseCase: SessionCreationUseCase,
    private val sessionStorageUseCase: SessionStorageUseCase,
    private val storeRequestTokenUseCase: StoreRequestTokenUseCase
) {
    suspend operator fun invoke(userName: String, password: String): Boolean {
        val requestToken = requestTokenUseCase()
        val validatedRequestToken = userRepository.login(LoginBodyEntity(userName, password, requestToken.requestToken))
        if (validatedRequestToken.requestToken == null) throw Exception("Login failed")
        val sessionId = sessionCreationUseCase(validatedRequestToken.requestToken)
        storeRequestTokenUseCase(requestToken.requestToken)
        sessionStorageUseCase(sessionId)
        return true
    }
}