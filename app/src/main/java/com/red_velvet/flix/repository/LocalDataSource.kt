package com.red_velvet.flix.repository

import com.red_velvet.flix.data.local.database.entity.AiringTodaySeriesDto
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieDto
import com.red_velvet.flix.data.local.database.entity.OnTheAirSeriesDto
import com.red_velvet.flix.data.local.database.entity.PopularMovieDto
import com.red_velvet.flix.data.local.database.entity.PopularSeriesDto
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieDto
import com.red_velvet.flix.data.local.database.entity.TopRatedSeriesDto
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieDto
import com.red_velvet.flix.data.local.database.entity.UserDto
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun getPopularMovies(): Flow<List<PopularMovieDto>>
    suspend fun getTopRatedMovies(): Flow<List<TopRatedMovieDto>>
    suspend fun getNowPlayingMovies(): Flow<List<NowPlayingMovieDto>>
    suspend fun getUpcomingMovies(): Flow<List<UpcomingMovieDto>>
    suspend fun insertPopularMovies(popularMovies: List<PopularMovieDto>)
    suspend fun insertTopRatedMovies(topRatedMovies: List<TopRatedMovieDto>)
    suspend fun insertNowPlayingMovies(nowPlayingMovies: List<NowPlayingMovieDto>)
    suspend fun insertUpcomingMovies(upcomingMovies: List<UpcomingMovieDto>)

    suspend fun getPopularSeries(): Flow<List<PopularSeriesDto>>
    suspend fun getTopRatedSeries(): Flow<List<TopRatedSeriesDto>>
    suspend fun getOnTheAirSeries(): Flow<List<OnTheAirSeriesDto>>
    suspend fun getAiringTodaySeries(): Flow<List<AiringTodaySeriesDto>>
    suspend fun insertPopularSeries(popularSeries: List<PopularSeriesDto>)
    suspend fun insertTopRatedSeries(topRatedSeries: List<TopRatedSeriesDto>)
    suspend fun insertOnTheAirSeries(onTheAirSeries: List<OnTheAirSeriesDto>)
    suspend fun insertAiringTodaySeries(airingTodaySeries: List<AiringTodaySeriesDto>)

    suspend fun getUserData(): UserDto
    suspend fun insertUserData(userDto: UserDto)

}