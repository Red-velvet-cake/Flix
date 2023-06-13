package com.red_velvet.flix.domain.usecase.login.user

import javax.inject.Inject

class PasswordValidateUseCase @Inject constructor() {
    operator fun invoke(password: String) = password.length > PASSWORD_LENGTH

    companion object {
        const val PASSWORD_LENGTH = 6
    }
}