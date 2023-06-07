package com.red_velvet.flix.domain.usecase.login

import javax.inject.Inject

class PasswordValidateUseCase @Inject constructor() {
    operator fun invoke(password: String) = password.length > 6
}