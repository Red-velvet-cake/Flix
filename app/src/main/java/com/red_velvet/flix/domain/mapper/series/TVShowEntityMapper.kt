package com.red_velvet.flix.domain.mapper.series

import com.red_velvet.flix.data.local.database.entity.AiringTodayTvShowEntity
import com.red_velvet.flix.data.local.database.entity.OnTheAirTvShowEntity
import com.red_velvet.flix.data.local.database.entity.PopularTvShowEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedTvShowEntity
import com.red_velvet.flix.domain.model.series.TVShow
import com.red_velvet.flix.domain.utils.orZero

fun List<PopularTvShowEntity>.toPopularTvShowModelList(): List<TVShow> {
    return map { it.toPopularTvShowModel() }
}

fun PopularTvShowEntity.toPopularTvShowModel(): TVShow {
    return TVShow(
        id = id.toInt(),
        name = title,
        imageUrl = imageUrl,
        firstAirDate = date,
        popularity = popularity.orZero(),
        voteAverage = voteAverage.orZero()
    )
}

fun List<TopRatedTvShowEntity>.toTopRatedTvShowModelList(): List<TVShow> {
    return map { it.toTopRatedTvShowModel() }
}

fun TopRatedTvShowEntity.toTopRatedTvShowModel(): TVShow {
    return TVShow(
        id = id.toInt(),
        name = title,
        imageUrl = imageUrl,
        firstAirDate = date,
        popularity = popularity.orZero(),
        voteAverage = voteAverage.orZero()
    )
}

fun AiringTodayTvShowEntity.toAirngTodayTvShowModel(): TVShow {
    return TVShow(
        id = id.toInt(),
        name = title,
        imageUrl = imageUrl,
        firstAirDate = date,
        popularity = popularity.orZero(),
        voteAverage = voteAverage.orZero()
    )
}

fun List<AiringTodayTvShowEntity>.toAiringTodayTvShowModelList(): List<TVShow> {
    return map { it.toAirngTodayTvShowModel() }
}

fun OnTheAirTvShowEntity.toOnTheAirTvShowModel(): TVShow {
    return TVShow(
        id = id.toInt(),
        name = title,
        imageUrl = imageUrl,
        firstAirDate = date,
        popularity = popularity.orZero(),
        voteAverage = voteAverage.orZero()
    )
}

fun List<OnTheAirTvShowEntity>.toOnTheAirTvShowModelList(): List<TVShow> {
    return map { it.toOnTheAirTvShowModel() }
}