package com.red_velvet.flix.domain.repository

import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.entity.TrailerEntity
import com.red_velvet.flix.domain.entity.series.EpisodeEntity
import com.red_velvet.flix.domain.entity.series.SeasonEntity
import com.red_velvet.flix.domain.entity.series.SeriesEntity

interface SeriesRepository {

    suspend fun getPopularSeries(
        page: Int? = null,
        language: String? = null,
    ): List<SeriesEntity>

    suspend fun getTopRatedSeries(
        page: Int? = null,
        language: String? = null,
    ): List<SeriesEntity>

    suspend fun getOnTheAirSeries(
        page: Int? = null,
        language: String? = null,
        timezone: String? = null,
    ): List<SeriesEntity>

    suspend fun getAiringTodaySeries(
        page: Int? = null,
        language: String? = null,
        timezone: String? = null,
    ): List<SeriesEntity>

    suspend fun getSeriesRecommendations(
        seriesId: Int,
        page: Int = 1,
    ): List<SeriesEntity>

    suspend fun getLatestSeries(): SeriesEntity

    suspend fun getSeriesKeywords(seriesId: Int): List<String>

    suspend fun getSeriesReviews(
        seriesId: Int,
        page: Int,
    ): List<ReviewEntity>

    suspend fun rateSeries(
        seriesId: Int,
        rating: Double
    )

    suspend fun getSeasonDetails(
        seriesId: Int,
        seasonNumber: Int,
    ): SeasonEntity

    suspend fun getSeasonImages(
        seriesId: Int,
        seasonNumber: Int,
    ): List<String>

    suspend fun getSeriesVideos(
        seriesId: Int,
    ): List<TrailerEntity>

    suspend fun getEpisodeDetails(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
    ): EpisodeEntity

    suspend fun getEpisodeImages(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
    ): List<String>

    suspend fun getEpisodeVideos(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
    ): List<TrailerEntity>

    suspend fun rateEpisode(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
        rating: Double
    )


    suspend fun getLocalPopularSeries(): List<SeriesEntity>

    suspend fun getLocalTopRatedSeries(): List<SeriesEntity>

    suspend fun getLocalOnTheAirSeries(): List<SeriesEntity>

    suspend fun getLocalAiringTodaySeries(): List<SeriesEntity>

    suspend fun cachePopularSeries(series: List<SeriesEntity>)

    suspend fun cacheTopRatedSeries(series: List<SeriesEntity>)

    suspend fun cacheOnTheAirSeries(series: List<SeriesEntity>)

    suspend fun cacheAiringTodaySeries(series: List<SeriesEntity>)

}