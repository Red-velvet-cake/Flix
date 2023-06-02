package com.red_velvet.flix.domain.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.local.database.entity.AiringTodayTvShowEntity
import com.red_velvet.flix.data.local.database.entity.OnTheAirTvShowEntity
import com.red_velvet.flix.data.local.database.entity.PopularTvShowEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedTvShowEntity
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

fun List<PopularTvShowEntity>.toPopularTVShowsModels(): List<TVShow> {
    return map { it.toModel() }
}

fun List<TopRatedTvShowEntity>.toTopRatedTVShowsModels(): List<TVShow> {
    return map { it.toModel() }
}

fun List<AiringTodayTvShowEntity>.toAiringTodayTvShowsModels(): List<TVShow> {
    return map { it.toModel() }
}

fun List<OnTheAirTvShowEntity>.toOnTheAirTvShowsModels(): List<TVShow> {
    return map { it.toModel() }
}