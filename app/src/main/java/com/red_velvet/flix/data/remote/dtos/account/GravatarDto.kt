package com.red_velvet.flix.data.remote.dtos.account


import com.google.gson.annotations.SerializedName

data class GravatarDto(
    @SerializedName("hash")
    val hash: String?
)