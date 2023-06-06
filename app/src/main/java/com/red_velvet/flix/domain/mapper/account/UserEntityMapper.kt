package com.red_velvet.flix.domain.mapper.account

import com.red_velvet.flix.data.local.database.entity.UserDto
import com.red_velvet.flix.domain.model.account.User

fun UserDto.toModel(): User {
    return User(
        userName = userName,
        name = name,
        imageUrl = imageUrl,
    )
}