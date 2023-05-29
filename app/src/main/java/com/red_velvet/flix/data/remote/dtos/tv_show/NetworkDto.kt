package com.red_velvet.flix.data.remote.dtos.tv_show


import com.google.gson.annotations.SerializedName

data class NetworkDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("logo_path")
    val logoPath: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("origin_country")
    val originCountry: String?
)