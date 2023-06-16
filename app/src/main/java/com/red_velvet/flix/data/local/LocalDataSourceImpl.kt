package com.red_velvet.flix.data.local

import com.red_velvet.flix.data.local.database.dao.MovieDao
import com.red_velvet.flix.data.local.database.dao.SeriesDao
import com.red_velvet.flix.data.local.database.dao.UserDao
import com.red_velvet.flix.data.local.database.entity.AiringTodaySeriesDto
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieDto
import com.red_velvet.flix.data.local.database.entity.OnTheAirSeriesDto
import com.red_velvet.flix.data.local.database.entity.PopularMovieDto
import com.red_velvet.flix.data.local.database.entity.PopularSeriesDto
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieDto
import com.red_velvet.flix.data.local.database.entity.TopRatedSeriesDto
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieDto
import com.red_velvet.flix.data.local.database.entity.UserDto
import com.red_velvet.flix.repository.LocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao, private val seriesDao: SeriesDao, private val userDao: UserDao
) : LocalDataSource {
    override fun getPopularMovies(): Flow<List<PopularMovieDto>> {
        return movieDao.getPopularMovies()
    }

    override fun getTopRatedMovies(): Flow<List<TopRatedMovieDto>> {
        return movieDao.getTopRatedMovies()
    }

    override fun getNowPlayingMovies(): Flow<List<NowPlayingMovieDto>> {
        return movieDao.getNowPlayingMovies()
    }

    override fun getUpcomingMovies(): Flow<List<UpcomingMovieDto>> {
        return movieDao.getUpcomingMovies()
    }

    override suspend fun insertPopularMovies(popularMovies: List<PopularMovieDto>) {
        movieDao.insertPopularMovies(popularMovies)
    }

    override suspend fun insertTopRatedMovies(topRatedMovies: List<TopRatedMovieDto>) {
        movieDao.insertTopRatedMovies(topRatedMovies)
    }

    override suspend fun insertNowPlayingMovies(nowPlayingMovies: List<NowPlayingMovieDto>) {
        movieDao.insertNowPlayingMovies(nowPlayingMovies)
    }

    override suspend fun insertUpcomingMovies(upcomingMovies: List<UpcomingMovieDto>) {
        movieDao.insertUpcomingMovies(upcomingMovies)
    }

    override fun getPopularSeries(): Flow<List<PopularSeriesDto>> {
        return seriesDao.getPopularSeries()
    }

    override fun getTopRatedSeries(): Flow<List<TopRatedSeriesDto>> {
        return seriesDao.getTopRatedSeries()
    }

    override fun getOnTheAirSeries(): Flow<List<OnTheAirSeriesDto>> {
        return seriesDao.getOnTheAirSeries()
    }

    override fun getAiringTodaySeries(): Flow<List<AiringTodaySeriesDto>> {
        return seriesDao.getAiringTodaySeries()
    }

    override suspend fun insertPopularSeries(popularSeries: List<PopularSeriesDto>) {
        seriesDao.insertPopularSeries(popularSeries)
    }

    override suspend fun insertTopRatedSeries(topRatedSeries: List<TopRatedSeriesDto>) {
        seriesDao.insertTopRatedSeries(topRatedSeries)
    }

    override suspend fun insertOnTheAirSeries(onTheAirSeries: List<OnTheAirSeriesDto>) {
        seriesDao.insertOnTheAirSeries(onTheAirSeries)
    }

    override suspend fun insertAiringTodaySeries(airingTodaySeries: List<AiringTodaySeriesDto>) {
        seriesDao.insertAiringTodaySeries(airingTodaySeries)
    }

    override suspend fun getUserData(): UserDto {
        return userDao.getUserData()
    }

    override suspend fun insertUserData(userDto: UserDto) {
        userDao.insertUserData(userDto)
    }
}