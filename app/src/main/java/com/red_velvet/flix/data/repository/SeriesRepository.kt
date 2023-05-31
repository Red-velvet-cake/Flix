package com.red_velvet.flix.data.repository

import com.red_velvet.flix.data.local.database.entity.AirngTodayTvShowEntity
import com.red_velvet.flix.data.local.database.entity.OnTheAirTvShowEntity
import com.red_velvet.flix.data.local.database.entity.PopularTvShowEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieEntity
import com.red_velvet.flix.data.remote.dtos.ApiResponse
import com.red_velvet.flix.data.remote.dtos.PaginationDto
import com.red_velvet.flix.data.remote.dtos.image.ImagesDto
import com.red_velvet.flix.data.remote.dtos.movie.KeywordsDto
import com.red_velvet.flix.data.remote.dtos.review.ReviewDto
import com.red_velvet.flix.data.remote.dtos.trailer.TrailersDto
import com.red_velvet.flix.data.remote.dtos.tv_show.SeasonDto
import com.red_velvet.flix.data.remote.dtos.tv_show.TVShowDto
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.*

interface SeriesRepository {
    suspend fun getOnTheAirSeries(page: Int): Flow<List<OnTheAirTvShowEntity>>

    suspend fun getAiringTodaySeries(page: Int): Flow<List<AirngTodayTvShowEntity>>

    suspend fun getPopularSeries(page: Int): Flow<List<PopularTvShowEntity>>

    suspend fun getTopRatedSeries(page: Int): Flow<List<TopRatedMovieEntity>>
    suspend fun getTVShowDetails(tvId: Int): TVShowDto
    suspend fun getTVShowImages(seriesId: Int): ImagesDto
    suspend fun getSimilarTVShows(tvId: Int, page: Int): PaginationDto<TVShowDto>

    suspend fun getTVShowTrailers(seriesId: Int): TrailersDto

    suspend fun getTVShowRecommendations(
        seriesId: Int,
        page: Int
    ): PaginationDto<TVShowDto>

    suspend fun getLatestTVShow(): TVShowDto

    suspend fun getTVShowKeywords(seriesId: Int): KeywordsDto

    suspend fun getTVShowReviews(seriesId: Int): PaginationDto<ReviewDto>

    suspend fun rateTVShow(
        seriesId: Int,
        rating: Double
    ): ApiResponse

    suspend fun getSeasonDetails(
        seriesId: Int,
        seasonNumber: Int
    ): SeasonDto


}

