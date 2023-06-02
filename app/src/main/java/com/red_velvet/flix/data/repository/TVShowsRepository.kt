package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.local.database.entity.AiringTodayTvShowEntity
import com.red_velvet.flix.data.local.database.entity.OnTheAirTvShowEntity
import com.red_velvet.flix.data.local.database.entity.PopularTvShowEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedTvShowEntity
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

interface TVShowsRepository {

    suspend fun getPopularTvShow(): Flow<List<PopularTvShowEntity>>

    fun getTopRatedTvShow(): Flow<List<TopRatedTvShowEntity>>

    suspend fun getOnTheAirTvShow(): Flow<List<OnTheAirTvShowEntity>>

    suspend fun getAiringTodayTvShow(): Flow<List<AiringTodayTvShowEntity>>

    suspend fun getTVShowRecommendations(
        seriesId: Int,
        page: Int = 1,
    ): PaginationDto<TVShowDto>

    suspend fun getLatestTVShow(): TVShowDto

    suspend fun getTVShowKeywords(seriesId: Int): KeywordsDto

    suspend fun getTVShowReviews(
        seriesId: Int,
        page: Int,
    ): PaginationDto<ReviewDto>

    suspend fun rateTVShow(
        seriesId: Int,
        rating: Double
    ): ApiResponse

    suspend fun getSeasonDetails(
        seriesId: Int,
        seasonNumber: Int,
    ): SeasonDto

    suspend fun getSeasonImages(
        seriesId: Int,
        seasonNumber: Int,
    ): ImagesDto

    suspend fun getTVShowVideos(
        seriesId: Int,
    ): TrailersDto

    suspend fun getEpisodeDetails(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
    ): EpisodeDto

    suspend fun getEpisodeImages(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
    ): ImagesDto

    suspend fun getEpisodeVideos(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
    ): TrailersDto

    suspend fun rateEpisode(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
        rating: Double
    ): ApiResponse

}