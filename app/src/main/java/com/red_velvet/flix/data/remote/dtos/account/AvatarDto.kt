package com.red_velvet.flix.data.remote.dtos.account


import com.google.gson.annotations.SerializedName

data class AvatarDto(
    @SerializedName("gravatar")
    val gravatar: GravatarDto?,
    @SerializedName("tmdb")
    val tmdb: TmdbDto?
)