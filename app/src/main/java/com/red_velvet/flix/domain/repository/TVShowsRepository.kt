package com.red_velvet.flix.domain.repository

import com.red_velvet.flix.domain.model.ReviewEntity
import com.red_velvet.flix.domain.model.TrailerEntity
import com.red_velvet.flix.domain.model.series.EpisodeEntity
import com.red_velvet.flix.domain.model.series.SeasonEntity
import com.red_velvet.flix.domain.model.series.SeriesEntity

interface TVShowsRepository {

    suspend fun getPopularTvShow(): List<SeriesEntity>

    suspend fun getTopRatedTvShow(): List<SeriesEntity>

    suspend fun getOnTheAirTvShow(): List<SeriesEntity>

    suspend fun getAiringTodayTvShow(): List<SeriesEntity>

    suspend fun getTVShowRecommendations(
        seriesId: Int,
        page: Int = 1,
    ): List<SeriesEntity>

    suspend fun getLatestTVShow(): SeriesEntity

    suspend fun getTVShowKeywords(seriesId: Int): List<String>

    suspend fun getTVShowReviews(
        seriesId: Int,
        page: Int,
    ): List<ReviewEntity>

    suspend fun rateTVShow(
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

    suspend fun getTVShowVideos(
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