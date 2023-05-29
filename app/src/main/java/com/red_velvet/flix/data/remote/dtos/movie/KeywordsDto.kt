package com.red_velvet.flix.data.remote.dtos.movie


import com.google.gson.annotations.SerializedName

data class KeywordsDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("keywords")
    val keywords: List<KeywordDto?>?
)