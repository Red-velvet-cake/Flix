package com.red_velvet.flix.domain.usecase.login

import javax.inject.Inject

class PasswordMatchingUseCase @Inject constructor() {
    operator fun invoke(password: String, confirmPassword: String) =
        password == confirmPassword && password.isNotEmpty()
}