package com.red_velvet.flix.domain.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.local.database.entity.AiringTodayTvShowEntity
import com.red_velvet.flix.data.local.database.entity.OnTheAirTvShowEntity
import com.red_velvet.flix.data.local.database.entity.PopularTvShowEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedTvShowEntity
import com.red_velvet.flix.data.remote.dtos.tv_show.TVShowDto
import com.red_velvet.flix.domain.model.series.TVShow

fun PopularTvShowEntity.toModel(): TVShow {
    return TVShow(
        id = id.toInt(),
        name = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        firstAirDate = date.orEmpty(),
        popularity = 0.0,
        voteAverage = 0.0,
    )
}


fun TopRatedTvShowEntity.toModel(): TVShow {
    return TVShow(
        id = id.toInt(),
        name = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        firstAirDate = date.orEmpty(),
        popularity = 0.0,
        voteAverage = 0.0,
    )
}


fun AiringTodayTvShowEntity.toModel(): TVShow {
    return TVShow(
        id = id.toInt(),
        name = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        firstAirDate = date.orEmpty(),
        popularity = 0.0,
        voteAverage = 0.0,
    )
}


fun OnTheAirTvShowEntity.toModel(): TVShow {
    return TVShow(
        id = id.toInt(),
        name = title,
        imageUrl = BuildConfig.IMAGE_BASE_PATH + imageUrl,
        firstAirDate = date.orEmpty(),
        popularity = 0.0,
        voteAverage = 0.0,
    )
}
fun List<PopularTvShowEntity>.toModel(): List<TVShow> {
    return map { it.toModel() }
}
fun List<TopRatedTvShowEntity>.toModel(): List<TVShow> {
    return map { it.toModel() }
}
fun List<AiringTodayTvShowEntity>.toModel(): List<TVShow> {
    return map { it.toModel() }
}
fun List<OnTheAirTvShowEntity>.toModel(): List<TVShow> {
    return map { it.toModel() }
}