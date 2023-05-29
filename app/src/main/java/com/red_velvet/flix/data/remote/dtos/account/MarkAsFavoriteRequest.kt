package com.red_velvet.flix.data.remote.dtos.account


import com.google.gson.annotations.SerializedName

data class MarkAsFavoriteRequest(
    @SerializedName("favorite")
    val favorite: Boolean?,
    @SerializedName("media_id")
    val mediaId: Int?,
    @SerializedName("media_type")
    val mediaType: String?
)