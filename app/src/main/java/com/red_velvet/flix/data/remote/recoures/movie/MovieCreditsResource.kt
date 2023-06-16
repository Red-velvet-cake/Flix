package com.red_velvet.flix.data.remote.recoures.movie

import com.google.gson.annotations.SerializedName
import com.red_velvet.flix.data.remote.recoures.person.MovieActorResource

data class MovieCreditsResource(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("cast")
    val cast: List<MovieActorResource>?,
    @SerializedName("crew")
    val crew: List<MovieCrewResource?>?
)