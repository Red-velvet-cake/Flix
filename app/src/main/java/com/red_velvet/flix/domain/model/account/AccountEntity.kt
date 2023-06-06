package com.red_velvet.flix.domain.model.account


data class AccountEntity(
    val id: Int,
    val name: String,
    val username: String,
    val avatarPath: String,
)