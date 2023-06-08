package com.red_velvet.flix.repository

import com.red_velvet.flix.data.local.database.dao.SeriesDao
import com.red_velvet.flix.data.remote.APIErrorHandler
import com.red_velvet.flix.data.remote.APIService
import com.red_velvet.flix.data.repository.mapper.series.toAiringTodaySeriesDto
import com.red_velvet.flix.data.repository.mapper.series.toAiringTodaySeriesEntity
import com.red_velvet.flix.data.repository.mapper.series.toEntity
import com.red_velvet.flix.data.repository.mapper.series.toOnTheAirSeriesDto
import com.red_velvet.flix.data.repository.mapper.series.toOnTheAirSeriesEntity
import com.red_velvet.flix.data.repository.mapper.series.toPopularSeriesDto
import com.red_velvet.flix.data.repository.mapper.series.toPopularSeriesEntity
import com.red_velvet.flix.data.repository.mapper.series.toTopRatedSeriesDto
import com.red_velvet.flix.data.repository.mapper.series.toTopRatedSeriesEntity
import com.red_velvet.flix.data.repository.mapper.toEntity
import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.entity.TrailerEntity
import com.red_velvet.flix.domain.entity.series.EpisodeEntity
import com.red_velvet.flix.domain.entity.series.SeasonEntity
import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import javax.inject.Inject

class SeriesRepositoryImpl @Inject constructor(
    private val apiService: APIService,
    private val seriesDao: SeriesDao,
    apiErrorHandler: APIErrorHandler
) : SeriesRepository {
    override suspend fun getPopularSeries(
        page: Int?,
        language: String?,
    ): List<SeriesEntity> {
        return wrapApiCall { apiService.getPopularSeries(page, language) }
            .items?.toEntity() ?: emptyList()
    }

    override suspend fun getTopRatedSeries(
        page: Int?,
        language: String?,
    ): List<SeriesEntity> {
        return wrapApiCall { apiService.getTopRatedSeries(page, language) }
            .items?.toEntity() ?: emptyList()
    }

    override suspend fun getOnTheAirSeries(
        page: Int?,
        language: String?,
        timezone: String?,
    ): List<SeriesEntity> {
        return wrapApiCall { apiService.getOnTheAirSeries(page, language, timezone) }
            .items?.toEntity() ?: emptyList()
    }

    override suspend fun getAiringTodaySeries(
        page: Int?,
        language: String?,
        timezone: String?,
    ): List<SeriesEntity> {
        return wrapApiCall { apiService.getAiringTodaySeries(page, language, timezone) }
            .items?.toEntity() ?: emptyList()
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
        return wrapApiCall { apiService.getEpisodeTrailers(seriesId, seasonNumber, episodeNumber) }
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

    override suspend fun getLocalPopularSeries(): List<SeriesEntity> {
        return seriesDao.getPopularSeries()
            .toPopularSeriesEntity()
    }

    override suspend fun getLocalTopRatedSeries(): List<SeriesEntity> {
        return seriesDao.getTopRatedSeries()
            .toTopRatedSeriesEntity()
    }

    override suspend fun getLocalOnTheAirSeries(): List<SeriesEntity> {
        return seriesDao.getOnTheAirSeries()
            .toOnTheAirSeriesEntity()
    }

    override suspend fun getLocalAiringTodaySeries(): List<SeriesEntity> {
        return seriesDao.getAiringTodaySeries()
            .toAiringTodaySeriesEntity()
    }

    override suspend fun cachePopularSeries(series: List<SeriesEntity>) {
        seriesDao.insertPopularSeries(series.toPopularSeriesDto())
    }

    override suspend fun cacheTopRatedSeries(series: List<SeriesEntity>) {
        seriesDao.insertTopRatedSeries(series.toTopRatedSeriesDto())
    }

    override suspend fun cacheOnTheAirSeries(series: List<SeriesEntity>) {
        seriesDao.insertOnTheAirSeries(series.toOnTheAirSeriesDto())
    }

    override suspend fun cacheAiringTodaySeries(series: List<SeriesEntity>) {
        seriesDao.insertAiringTodaySeries(series.toAiringTodaySeriesDto())
    }

}