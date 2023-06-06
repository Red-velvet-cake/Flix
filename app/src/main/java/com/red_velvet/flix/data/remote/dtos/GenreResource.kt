package com.red_velvet.flix.data.remote.dtos


import com.google.gson.annotations.SerializedName

data class GenreResource(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)