package com.red_velvet.flix.domain.usecase.login.user

import com.red_velvet.flix.domain.repository.UserRepository
import javax.inject.Inject

class StoreRequestTokenUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(requestToken: String) {
        userRepository.storeRequestToken(requestToken)
    }
}