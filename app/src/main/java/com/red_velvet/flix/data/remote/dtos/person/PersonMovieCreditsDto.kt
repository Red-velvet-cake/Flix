package com.red_velvet.flix.data.remote.dtos.person


import com.google.gson.annotations.SerializedName
import com.red_velvet.flix.data.remote.dtos.movie.MovieDto

data class PersonMovieCreditsDto(
    @SerializedName("cast")
    val cast: List<MovieDto?>?,
    @SerializedName("id")
    val id: Int?
)