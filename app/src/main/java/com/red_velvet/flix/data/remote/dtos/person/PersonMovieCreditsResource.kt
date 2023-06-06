package com.red_velvet.flix.data.remote.dtos.person


import com.google.gson.annotations.SerializedName
import com.red_velvet.flix.data.remote.dtos.movie.MovieResource

data class PersonMovieCreditsResource(
    @SerializedName("cast")
    val cast: List<MovieResource?>?,
    @SerializedName("id")
    val id: Int?
)