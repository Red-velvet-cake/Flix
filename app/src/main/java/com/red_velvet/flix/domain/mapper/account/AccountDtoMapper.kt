package com.red_velvet.flix.domain.mapper.account

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.dtos.account.AccountDto
import com.red_velvet.flix.domain.model.account.Account
import com.red_velvet.flix.domain.utils.orZero

fun AccountDto.toModel(): Account {
    return Account(
        id = id.orZero(),
        name = name.orEmpty(),
        username = username.orEmpty(),
        avatarPath = BuildConfig.IMAGE_BASE_PATH + avatar?.avatarPath,
    )
}