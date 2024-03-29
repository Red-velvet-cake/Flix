package com.red_velvet.flix.data.remote.recoures

import com.google.gson.annotations.SerializedName

data class Pagination<T>(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val items: List<T>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?,
)