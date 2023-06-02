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

    private suspend fun <T> wrap(request: suspend () -> Response<T>): T {
        val response = request()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Throwable()
        }
    }

    override suspend fun getTVShowRecommendations(seriesId: Int, page: Int): PaginationDto<TVShowDto> {
        return wrap {
            apiService.getTVShowRecommendations(seriesId, page)
        }
    }

    override suspend fun getLatestTVShow(): TVShowDto {
        return wrap {
            apiService.getLatestTVShow()
        }
    }

    override suspend fun getTVShowKeywords(seriesId: Int): KeywordsDto {
        return wrap {
            apiService.getTVShowKeywords(seriesId)
        }
    }

    override suspend fun getTVShowReviews(seriesId: Int, page: Int): PaginationDto<ReviewDto> {
        return wrap {
            apiService.getTVShowReviews(seriesId, page)
        }
    }

    override suspend fun rateTVShow(seriesId: Int, rating: Double): ApiResponse {
        return wrap {
            apiService.rateTVShow(seriesId, rating)
        }
    }

    override suspend fun getSeasonDetails(seriesId: Int, seasonNumber: Int): SeasonDto {
        return wrap {
            apiService.getSeasonDetails(seriesId, seasonNumber)
        }
    }

    override suspend fun getSeasonImages(seriesId: Int, seasonNumber: Int): ImagesDto {
        return wrap {
            apiService.getSeasonImages(seriesId, seasonNumber)
        }
    }

    override suspend fun getTVShowVideos(seriesId: Int): TrailersDto {
        return wrap {
            apiService.getTVShowVideos(seriesId)
        }
    }

    override suspend fun getEpisodeDetails(seriesId: Int, seasonNumber: Int, episodeNumber: Int): EpisodeDto {
        return wrap {
            apiService.getEpisodeDetails(seriesId, seasonNumber, episodeNumber)
        }
    }

    override suspend fun getEpisodeImages(seriesId: Int, seasonNumber: Int, episodeNumber: Int): ImagesDto {
        return wrap {
            apiService.getEpisodeImages(seriesId, seasonNumber, episodeNumber)
        }
    }

    override suspend fun getEpisodeVideos(seriesId: Int, seasonNumber: Int, episodeNumber: Int): TrailersDto {
        return wrap {
            apiService.getEpisodeVideos(seriesId, seasonNumber, episodeNumber)
        }
    }

    override suspend fun rateEpisode(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
        rating: Double
    ): ApiResponse {
        return wrap {
            apiService.rateEpisode(seriesId, seasonNumber, episodeNumber, rating)
        }
    }
}