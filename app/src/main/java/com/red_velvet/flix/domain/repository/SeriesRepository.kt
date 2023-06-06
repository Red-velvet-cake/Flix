package com.red_velvet.flix.domain.repository

import com.red_velvet.flix.domain.model.ReviewEntity
import com.red_velvet.flix.domain.model.TrailerEntity
import com.red_velvet.flix.domain.model.series.EpisodeEntity
import com.red_velvet.flix.domain.model.series.SeasonEntity
import com.red_velvet.flix.domain.model.series.SeriesEntity

interface SeriesRepository {

    suspend fun getPopularSeries(): List<SeriesEntity>

    suspend fun getTopRatedSeries(): List<SeriesEntity>

    suspend fun getOnTheAirSeries(): List<SeriesEntity>

    suspend fun getAiringTodaySeries(): List<SeriesEntity>

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

}