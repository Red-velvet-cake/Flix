package com.red_velvet.flix.data.remote.dtos.auth


import com.google.gson.annotations.SerializedName

data class SessionDto(
    @SerializedName("session_id")
    val sessionId: String?,
    @SerializedName("success")
    val success: Boolean?
)