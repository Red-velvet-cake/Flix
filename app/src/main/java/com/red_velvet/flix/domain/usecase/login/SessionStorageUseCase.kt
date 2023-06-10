package com.red_velvet.flix.domain.usecase.login

import com.red_velvet.flix.domain.repository.UserRepository
import javax.inject.Inject

class SessionStorageUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(sessionId: String) {
        userRepository.storeSessionId(sessionId)
    }
}