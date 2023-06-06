package com.red_velvet.flix.data.remote.recoures


import com.google.gson.annotations.SerializedName

data class GenreResource(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)