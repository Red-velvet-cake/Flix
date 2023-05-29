package com.red_velvet.flix.data.remote.dtos.trailer


import com.google.gson.annotations.SerializedName

data class TrailersDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("results")
    val results: List<TrailerDetailsDto?>?
)