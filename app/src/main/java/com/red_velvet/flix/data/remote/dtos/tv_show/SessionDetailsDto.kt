package com.red_velvet.flix.data.remote.dtos.tv_show


import com.google.gson.annotations.SerializedName

data class SessionDetailsDto(
    @SerializedName("air_date")
    val airDate: String?,
    @SerializedName("episodes")
    val episodes: List<EpisodeDto?>?,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("id")
    val seasonId: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("season_number")
    val seasonNumber: Int?
)