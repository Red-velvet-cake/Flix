package com.red_velvet.flix.data.remote.dtos.review


import com.google.gson.annotations.SerializedName

data class AuthorDetailsDto(
    @SerializedName("avatar_path")
    val avatarPath: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("rating")
    val rating: Int?,
    @SerializedName("username")
    val username: String?
)