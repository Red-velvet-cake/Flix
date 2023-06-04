package com.red_velvet.flix.data.repository

import com.red_velvet.flix.domain.model.Review
import com.red_velvet.flix.domain.model.Trailer
import com.red_velvet.flix.domain.model.series.Episode
import com.red_velvet.flix.domain.model.series.Season
import com.red_velvet.flix.domain.model.series.TVShow
import kotlinx.coroutines.flow.Flow

interface TVShowsRepository {

    suspend fun getPopularTvShow(): Flow<List<TVShow>>

    suspend fun getTopRatedTvShow(): Flow<List<TVShow>>

    suspend fun getOnTheAirTvShow(): Flow<List<TVShow>>

    suspend fun getAiringTodayTvShow(): Flow<List<TVShow>>

    suspend fun getTVShowRecommendations(
        seriesId: Int,
        page: Int = 1,
    ): List<TVShow>

    suspend fun getLatestTVShow(): TVShow

    suspend fun getTVShowKeywords(seriesId: Int): List<String>

    suspend fun getTVShowReviews(
        seriesId: Int,
        page: Int,
    ): List<Review>

    suspend fun rateTVShow(
        seriesId: Int,
        rating: Double
    )

    suspend fun getSeasonDetails(
        seriesId: Int,
        seasonNumber: Int,
    ): Season

    suspend fun getSeasonImages(
        seriesId: Int,
        seasonNumber: Int,
    ): List<String>

    suspend fun getTVShowVideos(
        seriesId: Int,
    ): List<Trailer>

    suspend fun getEpisodeDetails(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
    ): Episode

    suspend fun getEpisodeImages(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
    ): List<String>

    suspend fun getEpisodeVideos(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
    ): List<Trailer>

    suspend fun rateEpisode(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
        rating: Double
    )

}