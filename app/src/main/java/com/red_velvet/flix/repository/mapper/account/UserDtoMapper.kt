package com.red_velvet.flix.repository.mapper.account

import com.red_velvet.flix.data.local.database.entity.UserDto
import com.red_velvet.flix.data.remote.recoures.auth.LoginRequest
import com.red_velvet.flix.domain.entity.account.LoginBodyEntity
import com.red_velvet.flix.domain.entity.account.UserEntity

fun UserDto.toEntity(): UserEntity {
    return UserEntity(
        userName = userName,
        name = name,
        imageUrl = imageUrl,
    )
}

fun LoginBodyEntity.toResource(): LoginRequest {
    return LoginRequest(
        username = username,
        password = password,
        requestToken = requestToken,
    )
}