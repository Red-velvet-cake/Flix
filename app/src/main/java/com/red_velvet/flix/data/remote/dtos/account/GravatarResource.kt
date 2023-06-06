package com.red_velvet.flix.data.remote.dtos.account


import com.google.gson.annotations.SerializedName

data class GravatarResource(
    @SerializedName("hash")
    val hash: String?
)