package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.local.database.dao.SeriesDao
import com.red_velvet.flix.data.remote.MoviesService
import com.red_velvet.flix.data.repository.mapper.series.toAiringTodaySeriesEntity
import com.red_velvet.flix.data.repository.mapper.series.toEntity
import com.red_velvet.flix.data.repository.mapper.series.toOnTheAirSeriesEntity
import com.red_velvet.flix.data.repository.mapper.series.toPopularSeriesEntity
import com.red_velvet.flix.data.repository.mapper.series.toTopRatedSeriesEntity
import com.red_velvet.flix.data.repository.mapper.toEntity
import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.entity.TrailerEntity
import com.red_velvet.flix.domain.entity.series.EpisodeEntity
import com.red_velvet.flix.domain.entity.series.SeasonEntity
import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import com.red_velvet.flix.domain.utils.ExceptionHandler
import javax.inject.Inject

class SeriesRepositoryImpl @Inject constructor(
    private val apiService: MoviesService,
    private val seriesDao: SeriesDao,
    exceptionHandler: ExceptionHandler
) : SeriesRepository, BaseRepository(exceptionHandler) {
    override suspend fun getPopularSeries(): List<SeriesEntity> {
        return seriesDao.getPopularSeries()
            .toPopularSeriesEntity()
    }

    override suspend fun getTopRatedSeries(): List<SeriesEntity> {
        return seriesDao.getTopRatedSeries()
            .toTopRatedSeriesEntity()
    }

    override suspend fun getOnTheAirSeries(): List<SeriesEntity> {
        return seriesDao.getOnTheAirSeries()
            .toOnTheAirSeriesEntity()
    }

    override suspend fun getAiringTodaySeries(): List<SeriesEntity> {
        return seriesDao.getAiringTodaySeries()
            .toAiringTodaySeriesEntity()
    }

    override suspend fun getSeriesRecommendations(seriesId: Int, page: Int): List<SeriesEntity> {
        return wrapApiCall { apiService.getSeriesRecommendations(seriesId, page) }
            .items?.toEntity() ?: emptyList()
    }

    override suspend fun getLatestSeries(): SeriesEntity {
        return wrapApiCall { apiService.getLatestSeries() }
            .toEntity()
    }

    override suspend fun getSeriesKeywords(seriesId: Int): List<String> {
        return wrapApiCall { apiService.getSeriesKeywords(seriesId) }
            .toEntity()
    }

    override suspend fun getSeriesReviews(seriesId: Int, page: Int): List<ReviewEntity> {
        return wrapApiCall { apiService.getSeriesReviews(seriesId, page) }
            .items?.toEntity() ?: emptyList()
    }

    override suspend fun rateSeries(seriesId: Int, rating: Double) {
        wrapApiCall { apiService.rateSeries(seriesId, rating) }
    }

    override suspend fun getSeasonDetails(seriesId: Int, seasonNumber: Int): SeasonEntity {
        return wrapApiCall { apiService.getSeasonDetails(seriesId, seasonNumber) }
            .toEntity()
    }

    override suspend fun getSeasonImages(seriesId: Int, seasonNumber: Int): List<String> {
        return wrapApiCall { apiService.getSeasonImages(seriesId, seasonNumber) }
            .toEntity()
    }

    override suspend fun getSeriesVideos(seriesId: Int): List<TrailerEntity> {
        return wrapApiCall { apiService.getSeriesVideos(seriesId) }
            .toEntity()
    }

    override suspend fun getEpisodeDetails(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int
    ): EpisodeEntity {
        return wrapApiCall { apiService.getEpisodeDetails(seriesId, seasonNumber, episodeNumber) }
            .toEntity()
    }

    override suspend fun getEpisodeImages(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int
    ): List<String> {
        return wrapApiCall { apiService.getEpisodeImages(seriesId, seasonNumber, episodeNumber) }
            .toEntity()
    }

    override suspend fun getEpisodeVideos(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int
    ): List<TrailerEntity> {
        return wrapApiCall { apiService.getEpisodeVideos(seriesId, seasonNumber, episodeNumber) }
            .toEntity()
    }

    override suspend fun rateEpisode(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
        rating: Double
    ) {
        wrapApiCall { apiService.rateEpisode(seriesId, seasonNumber, episodeNumber, rating) }
    }

}