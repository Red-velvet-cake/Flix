package com.red_velvet.flix.data.repository.mapper.account

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.recoures.account.AccountResource
import com.red_velvet.flix.domain.entity.account.AccountEntity
import com.red_velvet.flix.domain.utils.orZero

fun AccountResource.toEntity(): AccountEntity {
    return AccountEntity(
        id = id.orZero(),
        name = name.orEmpty(),
        username = username.orEmpty(),
        avatarPath = BuildConfig.IMAGE_BASE_PATH + avatar?.avatarPath,
    )
}