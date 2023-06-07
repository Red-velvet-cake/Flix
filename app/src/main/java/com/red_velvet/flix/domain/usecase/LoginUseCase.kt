package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.repository.UserRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userName: String, password: String) {
        return userRepository.login(userName, password)
    }
}