package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.local.database.entity.AirngTodayTvShowEntity
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

    suspend fun insertPopularTvShow(popularTvShowEntity: PopularTvShowEntity)

    suspend fun insertTopRatedTvShow(topRatedTvShowEntity: TopRatedTvShowEntity)

    suspend fun insertOnTheAirTvShow(onTheAirTvShowEntity: OnTheAirTvShowEntity)

    suspend fun insertAiringTodayTvShow(airngTodayTvShowEntity: AirngTodayTvShowEntity)

    suspend fun getPopularTvShow(): Flow<List<PopularTvShowEntity>>

    suspend fun getTopRatedTvShow(): Flow<List<TopRatedTvShowEntity>>

    suspend fun getOnTheAirTvShow(): Flow<List<OnTheAirTvShowEntity>>

    suspend fun getAiringTodayTvShow(): Flow<List<AirngTodayTvShowEntity>>

    suspend fun getTVShowRecommendations(
        seriesId: Int,
        page: Int,
    ): PaginationDto<TVShowDto?>?

    suspend fun getLatestTVShow(): TVShowDto?

    suspend fun getTVShowKeywords(seriesId: Int): KeywordsDto?

    suspend fun getTVShowReviews(
        seriesId: Int,
        page: Int,
    ): PaginationDto<ReviewDto?>?

    suspend fun rateTVShow(
        seriesId: Int,
        rating: Double
    ): ApiResponse?

    suspend fun getSeasonDetails(
        seriesId: Int,
        seasonNumber: Int,
    ): SeasonDto?

    suspend fun getSeasonImages(
        seriesId: Int,
        seasonNumber: Int,
    ): ImagesDto?

    suspend fun getTVShowVideos(
        seriesId: Int,
    ): TrailersDto?

    suspend fun getEpisodeDetails(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
    ): EpisodeDto?

    suspend fun getEpisodeImages(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
    ): ImagesDto?

    suspend fun getEpisodeVideos(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
    ): TrailersDto?

    suspend fun getEpisodeRating(
        seriesId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
        rating: Double
    ): ApiResponse?

}