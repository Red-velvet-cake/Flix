package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.local.database.dao.TvShowDao
import com.red_velvet.flix.data.local.database.entity.*
import com.red_velvet.flix.data.remote.MoviesService
import com.red_velvet.flix.data.remote.dtos.ApiResponse
import com.red_velvet.flix.data.remote.dtos.PaginationDto
import com.red_velvet.flix.data.remote.dtos.image.ImagesDto
import com.red_velvet.flix.data.remote.dtos.movie.KeywordsDto
import com.red_velvet.flix.data.remote.dtos.review.ReviewDto
import com.red_velvet.flix.data.remote.dtos.trailer.TrailersDto
import com.red_velvet.flix.data.remote.dtos.tv_show.EpisodeDto
import com.red_velvet.flix.data.remote.dtos.tv_show.SeasonDto
import com.red_velvet.flix.data.remote.dtos.tv_show.TVShowDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class TVShowsRepositoryImpl @Inject constructor(
    private val apiService: MoviesService,
    private val tvShowDao: TvShowDao,
) : TVShowsRepository {
    override suspend fun getPopularTvShow(): Flow<List<PopularTvShowEntity>> {
        TODO("Not yet implemented")
    }

    override fun getTopRatedTvShow(): Flow<List<TopRatedTvShowEntity>> {
        return flow {
            emit(tvShowDao.getTopRatedTvShow())
        }

    }

    override suspend fun getOnTheAirTvShow(): Flow<List<OnTheAirTvShowEntity>> {
        return flow {
            emit(tvShowDao.getOnTheAirTvShow())
        }
    }

    override suspend fun getAiringTodayTvShow(): Flow<List<AiringTodayTvShowEntity>> {
        return flow {
            emit(tvShowDao.getAiringTodayTvShow())
        }
    }

    private suspend fun <T> wrap(request: suspend () -> Response<T>) {
        val response = request()
        if (response.isSuccessful) {
            val items = response.body()
        } else {
            throw Throwable()
        }
    }

    override suspend fun getTVShowRecommendations(seriesId: Int, page: Int): PaginationDto<TVShowDto> {
        val response = apiService.getTVShowRecommendations(seriesId, page)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getLatestTVShow(): TVShowDto {
        val response = apiService.getLatestTVShow()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getTVShowKeywords(seriesId: Int): KeywordsDto {
        val response = apiService.getTVShowKeywords(seriesId)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getTVShowReviews(seriesId: Int, page: Int): PaginationDto<ReviewDto> {
        val response = apiService.getTVShowReviews(seriesId, page)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun rateTVShow(seriesId: Int, rating: Double): ApiResponse {
        val response = apiService.rateTVShow(seriesId, rating)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getSeasonDetails(seriesId: Int, seasonNumber: Int): SeasonDto {
        val response = apiService.getSeasonDetails(seriesId, seasonNumber)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getSeasonImages(seriesId: Int, seasonNumber: Int): ImagesDto {
        val response = apiService.getSeasonImages(seriesId, seasonNumber)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getTVShowVideos(seriesId: Int): TrailersDto {
        val response = apiService.getTVShowVideos(seriesId)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getEpisodeDetails(seriesId: Int, seasonNumber: Int, episodeNumber: Int): EpisodeDto {
        val response = apiService.getEpisodeDetails(seriesId, seasonNumber, episodeNumber)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getEpisodeImages(seriesId: Int, seasonNumber: Int, episodeNumber: Int): ImagesDto {
        val response = apiService.getEpisodeImages(seriesId, seasonNumber, episodeNumber)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getEpisodeVideos(seriesId: Int, seasonNumber: Int, episodeNumber: Int): TrailersDto {
        val response = apiService.getEpisodeVideos(seriesId, seasonNumber, episodeNumber)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun rateEpisode(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
        rating: Double
    ): ApiResponse {
        val response = apiService.rateEpisode(seriesId, seasonNumber, episodeNumber, rating)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

}