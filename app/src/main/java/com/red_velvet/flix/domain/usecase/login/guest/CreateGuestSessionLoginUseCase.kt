package com.red_velvet.flix.domain.usecase.login.guest

import com.red_velvet.flix.domain.repository.UserRepository
import com.red_velvet.flix.domain.usecase.login.user.SessionStorageUseCase
import javax.inject.Inject

class CreateGuestSessionLoginUseCase  @Inject constructor(
    private val userRepository: UserRepository,
    private val sessionStorageUseCase: SessionStorageUseCase
) {
    suspend operator fun invoke(): Boolean {
        return try {
            val guestSessionId = userRepository.createGuestSession()
            sessionStorageUseCase(guestSessionId)
            true
        } catch (e: Exception) {
            false
        }
    }
}