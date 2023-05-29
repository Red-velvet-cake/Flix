package com.red_velvet.flix.data.remote.dtos.auth


import com.google.gson.annotations.SerializedName

data class TokenDto(
    @SerializedName("expires_at")
    val expiresAt: String?,
    @SerializedName("request_token")
    val requestToken: String?,
    @SerializedName("success")
    val success: Boolean?
)