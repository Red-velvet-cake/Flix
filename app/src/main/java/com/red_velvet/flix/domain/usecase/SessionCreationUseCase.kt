package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.repository.UserRepository
import javax.inject.Inject

class SessionCreationUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(requestToken: String): String {
        return userRepository.createSession(requestToken)
    }
}