package com.red_velvet.flix.domain.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.local.database.entity.AiringTodayTvShowEntity
import com.red_velvet.flix.data.local.database.entity.OnTheAirTvShowEntity
import com.red_velvet.flix.data.local.database.entity.PopularTvShowEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedTvShowEntity
import com.red_velvet.flix.data.remote.dtos.tv_show.TVShowDto
import com.red_velvet.flix.domain.model.series.TVShow
import com.red_velvet.flix.domain.utils.orZero

fun TVShowDto.toModel(): TVShow {
    return TVShow(
        id = id.orZero(),
        name = name.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        firstAirDate = firstAirDate.orEmpty(),
        popularity = popularity.orZero(),
        voteAverage = voteAverage.orZero()
    )
}

fun List<TVShowDto>.toModel(): List<TVShow> {
    return map { it.toModel() }
}


fun TVShowDto.toPopularTvShowEntity(): PopularTvShowEntity {
    return PopularTvShowEntity(
        id = id.orZero().toLong(),
        title = name.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = firstAirDate.orEmpty()
    )
}


fun List<TVShowDto>.toPopularTvShowEntityList(): List<PopularTvShowEntity> {
    return map { it.toPopularTvShowEntity() }
}

fun TVShowDto.toTopRatedTvShowEntity(): TopRatedTvShowEntity {
    return TopRatedTvShowEntity(
        id = id.orZero().toLong(),
        title = name.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = firstAirDate.orEmpty()
    )
}

fun List<TVShowDto>.toTopRatedTvShowEntityList(): List<TopRatedTvShowEntity> {
    return map { it.toTopRatedTvShowEntity() }
}


fun TVShowDto.toAirngTodayTvShowEntity(): AiringTodayTvShowEntity {
    return AiringTodayTvShowEntity(
        id = id.orZero().toLong(),
        title = name.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = firstAirDate.orEmpty()
    )
}

fun List<TVShowDto>.toAiringTodayTvShowEntityList(): List<AiringTodayTvShowEntity> {
    return map { it.toAirngTodayTvShowEntity() }
}

fun TVShowDto.toOnTheAirTvShowEntity(): OnTheAirTvShowEntity {
    return OnTheAirTvShowEntity(
        id = id.orZero().toLong(),
        title = name.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = firstAirDate.orEmpty()
    )
}

fun List<TVShowDto>.toOnTheAirTvShowEntityList(): List<OnTheAirTvShowEntity> {
    return map { it.toOnTheAirTvShowEntity() }
}
