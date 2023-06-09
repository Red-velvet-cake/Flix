package com.red_velvet.flix.repository.mapper.account

import com.red_velvet.flix.data.remote.recoures.auth.TokenResource
import com.red_velvet.flix.domain.entity.account.TokenEntity

fun TokenResource.toEntity() = TokenEntity(
    expiresAt = expiresAt ?: "",
    requestToken = requestToken ?: ""
)