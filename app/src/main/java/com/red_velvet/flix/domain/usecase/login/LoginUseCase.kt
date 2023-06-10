package com.red_velvet.flix.domain.usecase.login

import com.red_velvet.flix.domain.entity.account.LoginBodyEntity
import com.red_velvet.flix.domain.repository.UserRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val requestTokenUseCase: RequestTokenUseCase,
    private val sessionCreationUseCase: SessionCreationUseCase,
    private val sessionStorageUseCase: SessionStorageUseCase,
    private val storeRequestTokenUseCase: StoreRequestTokenUseCase
) {
    suspend operator fun invoke(userName: String, password: String): Boolean {
        return try {
            val requestToken = requestTokenUseCase()
            val validatedRequestToken = userRepository.login(LoginBodyEntity(userName, password, requestToken.requestToken))
            val sessionId = sessionCreationUseCase(validatedRequestToken.requestToken)
            storeRequestTokenUseCase(requestToken.requestToken)
            sessionStorageUseCase(sessionId)
            true
        } catch (e: Exception) {
            false
        }
    }
}