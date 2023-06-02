package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.UserRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke() {
        userRepository.logout()
    }
}