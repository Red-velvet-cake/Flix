package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.entity.account.TokenEntity
import com.red_velvet.flix.domain.repository.UserRepository
import javax.inject.Inject

class RequestTokenUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): TokenEntity {
        return userRepository.getRequestToken()
    }
}