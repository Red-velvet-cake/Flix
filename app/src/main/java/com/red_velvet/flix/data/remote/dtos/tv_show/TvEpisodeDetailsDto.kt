package com.red_velvet.flix.data.remote.dtos.tv_show


import com.google.gson.annotations.SerializedName

data class TvEpisodeDetailsDto(
    @SerializedName("air_date")
    val airDate: String?,
    @SerializedName("crew")
    val crew: List<CrewDto?>?,
    @SerializedName("episode_number")
    val episodeNumber: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("production_code")
    val productionCode: String?,
    @SerializedName("runtime")
    val runtime: Int?,
    @SerializedName("season_number")
    val seasonNumber: Int?,
    @SerializedName("still_path")
    val stillPath: String?,
    @SerializedName("vote_average")
    val voteAverage: Int?,
    @SerializedName("vote_count")
    val voteCount: Int?
)