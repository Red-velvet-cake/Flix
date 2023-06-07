package com.red_velvet.flix.domain.usecase.login

import javax.inject.Inject

class UserNameValidateUseCase @Inject constructor() {
    operator fun invoke(userName: String) = userName.isNotEmpty()
}