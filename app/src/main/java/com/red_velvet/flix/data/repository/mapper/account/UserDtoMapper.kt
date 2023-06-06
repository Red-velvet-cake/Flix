package com.red_velvet.flix.data.repository.mapper.account

import com.red_velvet.flix.data.local.database.entity.UserDto
import com.red_velvet.flix.domain.entity.account.UserEntity

fun UserDto.toEntity(): UserEntity {
    return UserEntity(
        userName = userName,
        name = name,
        imageUrl = imageUrl,
    )
}