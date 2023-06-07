package com.red_velvet.flix.data.remote.recoures.movie


import com.google.gson.annotations.SerializedName

data class KeywordsResource(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("keywords")
    val keywords: List<KeywordResource?>?
)