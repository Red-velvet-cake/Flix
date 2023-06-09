package com.red_velvet.flix.domain.usecase.login

import com.red_velvet.flix.domain.entity.account.LoginBodyEntity
import com.red_velvet.flix.domain.repository.UserRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userName: String, password: String) {
        userRepository.login(
            LoginBodyEntity(
                userName,
                password,
                ""
            )
        )
    }
}