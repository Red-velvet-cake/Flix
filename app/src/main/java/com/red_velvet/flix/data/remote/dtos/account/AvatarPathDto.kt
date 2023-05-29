package com.red_velvet.flix.data.remote.dtos.account


import com.google.gson.annotations.SerializedName

data class AvatarPathDto(
    @SerializedName("avatar_path")
    val avatarPath: String?
)