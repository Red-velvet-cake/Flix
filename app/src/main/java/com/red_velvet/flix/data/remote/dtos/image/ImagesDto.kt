package com.red_velvet.flix.data.remote.dtos.image


import com.google.gson.annotations.SerializedName

data class ImagesDto(
    @SerializedName("backdrops")
    val backdrops: List<ImageDto?>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("logos")
    val logos: List<Any?>?,
    @SerializedName("posters")
    val posters: List<ImageDto?>?,
    @SerializedName("stills")
    val stills: List<ImageDto?>?
)