package com.red_velvet.flix.data.remote.dtos.movie


import com.google.gson.annotations.SerializedName

data class KeywordDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)