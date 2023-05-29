package com.red_velvet.flix.data.remote.dtos.auth


import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("password")
    val password: String?,
    @SerializedName("request_token")
    val requestToken: String?,
    @SerializedName("username")
    val username: String?
)