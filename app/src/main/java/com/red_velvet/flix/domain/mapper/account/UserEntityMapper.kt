package com.red_velvet.flix.domain.mapper.account

import com.red_velvet.flix.data.local.database.entity.UserDto
import com.red_velvet.flix.domain.entity.account.UserEntity

fun UserDto.toModel(): UserEntity {
    return UserEntity(
        userName = userName,
        name = name,
        imageUrl = imageUrl,
    )
}