package com.red_velvet.flix.domain.mapper.account

import com.red_velvet.flix.data.local.database.entity.UserEntity
import com.red_velvet.flix.domain.model.account.User

fun UserEntity.toModel(): User {
    return User(
        userName = userName,
        name = name,
        imageUrl = imageUrl,
    )
}