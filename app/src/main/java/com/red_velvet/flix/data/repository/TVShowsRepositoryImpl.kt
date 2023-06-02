package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.local.database.entity.*
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
import retrofit2.Response

class TVShowsRepositoryImpl : TVShowsRepository {
    override suspend fun getPopularTvShow(): Flow<List<PopularTvShowEntity>> {
        TODO("Not yet implemented")
    }

    protected suspend fun <I, O> wrap(
        function: suspend () -> Response<I>,
        mapper: (I) -> O
    ): O {
        val response = function()
        return if (response.isSuccessful) {
            response.body()?.let { mapper(it) } ?: throw Throwable()
        } else {
            throw Throwable("response is not successful")
        }
    }
    override suspend fun getTopRatedTvShow(): Flow<List<TopRatedTvShowEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getOnTheAirTvShow(): Flow<List<OnTheAirTvShowEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getAiringTodayTvShow(): Flow<List<AiringTodayTvShowEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTVShowRecommendations(seriesId: Int, page: Int): PaginationDto<TVShowDto?> {
        TODO("Not yet implemented")
    }

    override suspend fun getLatestTVShow(): TVShowDto {
        TODO("Not yet implemented")
    }

    override suspend fun getTVShowKeywords(seriesId: Int): KeywordsDto {
        TODO("Not yet implemented")
    }

    override suspend fun getTVShowReviews(seriesId: Int, page: Int): PaginationDto<ReviewDto?> {
        TODO("Not yet implemented")
    }

    override suspend fun rateTVShow(seriesId: Int, rating: Double): ApiResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getSeasonDetails(seriesId: Int, seasonNumber: Int): SeasonDto {
        TODO("Not yet implemented")
    }

    override suspend fun getSeasonImages(seriesId: Int, seasonNumber: Int): ImagesDto {
        TODO("Not yet implemented")
    }

    override suspend fun getTVShowVideos(seriesId: Int): TrailersDto {
        TODO("Not yet implemented")
    }

    override suspend fun getEpisodeDetails(seriesId: Int, seasonNumber: Int, episodeNumber: Int): EpisodeDto {
        TODO("Not yet implemented")
    }

    override suspend fun getEpisodeImages(seriesId: Int, seasonNumber: Int, episodeNumber: Int): ImagesDto {
        TODO("Not yet implemented")
    }

    override suspend fun getEpisodeVideos(seriesId: Int, seasonNumber: Int, episodeNumber: Int): TrailersDto {
        TODO("Not yet implemented")
    }

    override suspend fun rateEpisode(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
        rating: Double
    ): ApiResponse {
        TODO("Not yet implemented")
    }

}