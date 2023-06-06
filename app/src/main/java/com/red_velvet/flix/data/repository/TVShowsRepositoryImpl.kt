package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.local.database.dao.TvShowDao
import com.red_velvet.flix.data.remote.MoviesService
import com.red_velvet.flix.domain.mapper.series.toAiringTodayTvShowsModels
import com.red_velvet.flix.domain.mapper.series.toModel
import com.red_velvet.flix.domain.mapper.series.toOnTheAirTvShowsModels
import com.red_velvet.flix.domain.mapper.series.toPopularTVShowsModels
import com.red_velvet.flix.domain.mapper.series.toTopRatedTVShowsModels
import com.red_velvet.flix.domain.mapper.toModel
import com.red_velvet.flix.domain.model.Review
import com.red_velvet.flix.domain.model.Trailer
import com.red_velvet.flix.domain.model.series.Episode
import com.red_velvet.flix.domain.model.series.Season
import com.red_velvet.flix.domain.model.series.TVShow
import com.red_velvet.flix.domain.utils.ExceptionHandler
import javax.inject.Inject

class TVShowsRepositoryImpl @Inject constructor(
    private val apiService: MoviesService,
    private val tvShowDao: TvShowDao,
    private val exceptionHandler: ExceptionHandler
) : TVShowsRepository {
    override suspend fun getPopularTvShow(): List<TVShow> {
        return tvShowDao.getPopularTvShow().toPopularTVShowsModels()
    }

    override suspend fun getTopRatedTvShow(): List<TVShow> {
        return tvShowDao.getTopRatedTvShow().toTopRatedTVShowsModels()
    }

    override suspend fun getOnTheAirTvShow(): List<TVShow> {
        return tvShowDao.getOnTheAirTvShow().toOnTheAirTvShowsModels()
    }

    override suspend fun getAiringTodayTvShow(): List<TVShow> {
        return tvShowDao.getAiringTodayTvShow().toAiringTodayTvShowsModels()
    }

    override suspend fun getTVShowRecommendations(seriesId: Int, page: Int): List<TVShow> {
        val response = apiService.getTVShowRecommendations(seriesId, page)
        if (response.isSuccessful) {
            return response.body()?.items?.toModel()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getLatestTVShow(): TVShow {
        val response = apiService.getLatestTVShow()
        if (response.isSuccessful) {
            return response.body()?.toModel()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getTVShowKeywords(seriesId: Int): List<String> {
        val response = apiService.getTVShowKeywords(seriesId)
        if (response.isSuccessful) {
            return response.body()?.toModel()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getTVShowReviews(seriesId: Int, page: Int): List<Review> {
        val response = apiService.getTVShowReviews(seriesId, page)
        if (response.isSuccessful) {
            return response.body()?.items?.toModel()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun rateTVShow(seriesId: Int, rating: Double) {
        val response = apiService.rateTVShow(seriesId, rating)
        if (!response.isSuccessful) {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getSeasonDetails(seriesId: Int, seasonNumber: Int): Season {
        val response = apiService.getSeasonDetails(seriesId, seasonNumber)
        if (response.isSuccessful) {
            return response.body()?.toModel()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getSeasonImages(seriesId: Int, seasonNumber: Int): List<String> {
        val response = apiService.getSeasonImages(seriesId, seasonNumber)
        if (response.isSuccessful) {
            return response.body()?.toModel()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getTVShowVideos(seriesId: Int): List<Trailer> {
        val response = apiService.getTVShowVideos(seriesId)
        if (response.isSuccessful) {
            return response.body()?.toModel()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getEpisodeDetails(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int
    ): Episode {
        val response = apiService.getEpisodeDetails(seriesId, seasonNumber, episodeNumber)
        if (response.isSuccessful) {
            return response.body()?.toModel()!!
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
            return response.body()?.toModel()!!
        } else {
            throw exceptionHandler.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getEpisodeVideos(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int
    ): List<Trailer> {
        val response = apiService.getEpisodeVideos(seriesId, seasonNumber, episodeNumber)
        if (response.isSuccessful) {
            return response.body()?.toModel()!!
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