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
    private val exceptionHandler: ExceptionHandler
) : SeriesRepository {
    override suspend fun getPopularSeries(): List<SeriesEntity> {
        return seriesDao.getPopularSeries().toPopularSeriesEntity()
    }

    override suspend fun getTopRatedSeries(): List<SeriesEntity> {
        return seriesDao.getTopRatedSeries().toTopRatedSeriesEntity()
    }

    override suspend fun getOnTheAirSeries(): List<SeriesEntity> {
        return seriesDao.getOnTheAirSeries().toOnTheAirSeriesEntity()
    }

    override suspend fun getAiringTodaySeries(): List<SeriesEntity> {
        return seriesDao.getAiringTodaySeries().toAiringTodaySeriesEntity()
    }

    override suspend fun getSeriesRecommendations(seriesId: Int, page: Int): List<SeriesEntity> {
        val response = apiService.getSeriesRecommendations(seriesId, page)
        if (response.isSuccessful) {
            return response.body()?.items?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getLatestSeries(): SeriesEntity {
        val response = apiService.getLatestSeries()
        if (response.isSuccessful) {
            return response.body()?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getSeriesKeywords(seriesId: Int): List<String> {
        val response = apiService.getSeriesKeywords(seriesId)
        if (response.isSuccessful) {
            return response.body()?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getSeriesReviews(seriesId: Int, page: Int): List<ReviewEntity> {
        val response = apiService.getSeriesReviews(seriesId, page)
        if (response.isSuccessful) {
            return response.body()?.items?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun rateSeries(seriesId: Int, rating: Double) {
        val response = apiService.rateSeries(seriesId, rating)
        if (!response.isSuccessful) {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getSeasonDetails(seriesId: Int, seasonNumber: Int): SeasonEntity {
        val response = apiService.getSeasonDetails(seriesId, seasonNumber)
        if (response.isSuccessful) {
            return response.body()?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getSeasonImages(seriesId: Int, seasonNumber: Int): List<String> {
        val response = apiService.getSeasonImages(seriesId, seasonNumber)
        if (response.isSuccessful) {
            return response.body()?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getSeriesVideos(seriesId: Int): List<TrailerEntity> {
        val response = apiService.getSeriesVideos(seriesId)
        if (response.isSuccessful) {
            return response.body()?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getEpisodeDetails(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int
    ): EpisodeEntity {
        val response = apiService.getEpisodeDetails(seriesId, seasonNumber, episodeNumber)
        if (response.isSuccessful) {
            return response.body()?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getEpisodeImages(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int
    ): List<String> {
        val response = apiService.getEpisodeImages(seriesId, seasonNumber, episodeNumber)
        if (response.isSuccessful) {
            return response.body()?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getEpisodeVideos(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int
    ): List<TrailerEntity> {
        val response = apiService.getEpisodeVideos(seriesId, seasonNumber, episodeNumber)
        if (response.isSuccessful) {
            return response.body()?.toEntity()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun rateEpisode(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
        rating: Double
    ) {
        val response = apiService.rateEpisode(seriesId, seasonNumber, episodeNumber, rating)
        if (!response.isSuccessful) {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

}