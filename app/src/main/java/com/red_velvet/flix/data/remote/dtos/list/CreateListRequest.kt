package com.red_velvet.flix.data.remote.dtos.list


import com.google.gson.annotations.SerializedName

data class CreateListRequest(
    @SerializedName("description")
    val description: String?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("name")
    val name: String?
)