package com.red_velvet.flix.repository

import com.red_velvet.flix.data.local.database.dao.SeriesDao
import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.entity.TrailerEntity
import com.red_velvet.flix.domain.entity.series.EpisodeEntity
import com.red_velvet.flix.domain.entity.series.SeasonEntity
import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import com.red_velvet.flix.repository.mapper.series.toAiringTodaySeriesDto
import com.red_velvet.flix.repository.mapper.series.toAiringTodaySeriesEntity
import com.red_velvet.flix.repository.mapper.series.toEntity
import com.red_velvet.flix.repository.mapper.series.toOnTheAirSeriesDto
import com.red_velvet.flix.repository.mapper.series.toOnTheAirSeriesEntity
import com.red_velvet.flix.repository.mapper.series.toPopularSeriesDto
import com.red_velvet.flix.repository.mapper.series.toPopularSeriesEntity
import com.red_velvet.flix.repository.mapper.series.toTopRatedSeriesDto
import com.red_velvet.flix.repository.mapper.series.toTopRatedSeriesEntity
import com.red_velvet.flix.repository.mapper.toEntity
import javax.inject.Inject

class SeriesRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val seriesDao: SeriesDao,
) : SeriesRepository {
    override suspend fun getPopularSeries(page: Int?): List<SeriesEntity> {
        return remoteDataSource.getPopularSeries(page).toEntity()
    }

    override suspend fun getTopRatedSeries(page: Int?): List<SeriesEntity> {
        return remoteDataSource.getTopRatedSeries(page).toEntity()
    }

    override suspend fun getOnTheAirSeries(page: Int?): List<SeriesEntity> {
        return remoteDataSource.getOnTheAirSeries(page).toEntity()
    }

    override suspend fun getAiringTodaySeries(page: Int?): List<SeriesEntity> {
        return remoteDataSource.getAiringTodaySeries(page).toEntity()
    }

    override suspend fun getSeriesRecommendations(seriesId: Int, page: Int?): List<SeriesEntity> {
        return remoteDataSource.getSeriesRecommendations(seriesId, page).toEntity()
    }

    override suspend fun getLatestSeries(): SeriesEntity {
        return remoteDataSource.getLatestSeries().toEntity()
    }

    override suspend fun getSeriesKeywords(seriesId: Int): List<String> {
        return remoteDataSource.getSeriesKeywords(seriesId).toEntity()
    }

    override suspend fun getSeriesReviews(seriesId: Int, page: Int?): List<ReviewEntity> {
        return remoteDataSource.getSeriesReviews(seriesId, page).toEntity()
    }

    override suspend fun rateSeries(seriesId: Int, rate: Float) {
        remoteDataSource.rateSeries(seriesId, rate)
    }

    override suspend fun getSeasonDetails(seriesId: Int, seasonNumber: Int): SeasonEntity {
        return remoteDataSource.getSeasonDetails(seriesId, seasonNumber).toEntity()
    }

    override suspend fun getSeasonImages(seriesId: Int, seasonNumber: Int): List<String> {
        return remoteDataSource.getSeasonImages(seriesId, seasonNumber).toEntity()
    }

    override suspend fun getSeriesTrailers(seriesId: Int): List<TrailerEntity> {
        return remoteDataSource.getSeriesTrailers(seriesId).toEntity()
    }

    override suspend fun getEpisodeDetails(
        seriesId: Int,
        season: Int,
        episode: Int
    ): EpisodeEntity {
        return remoteDataSource.getEpisodeDetails(seriesId, season, episode).toEntity()
    }

    override suspend fun getEpisodeImages(seriesId: Int, season: Int, episode: Int): List<String> {
        return remoteDataSource.getEpisodeImages(seriesId, season, episode).toEntity()
    }

    override suspend fun getEpisodeTrailers(
        seriesId: Int,
        season: Int,
        episode: Int
    ): List<TrailerEntity> {
        return remoteDataSource.getEpisodeTrailers(seriesId, season, episode).toEntity()
    }

    override suspend fun rateEpisode(seriesId: Int, season: Int, episode: Int, rate: Float) {
        remoteDataSource.rateEpisode(seriesId, season, episode, rate)
    }

    override suspend fun getSeriesDetails(seriesId: Int): SeriesEntity {
        return remoteDataSource.getSeriesDetails(seriesId).toEntity()
    }

    override suspend fun getSeriesImages(seriesId: Int): List<String> {
        return remoteDataSource.getSeriesImages(seriesId).toEntity()
    }

    override suspend fun getSimilarSeries(seriesId: Int, page: Int?): List<SeriesEntity> {
        return remoteDataSource.getSimilarSeries(seriesId, page).toEntity()
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