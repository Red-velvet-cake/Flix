package com.red_velvet.flix.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.red_velvet.flix.data.local.database.dao.MovieDao
import com.red_velvet.flix.data.local.database.dao.TvShowDao
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

@Database(
    entities = [
        AiringTodaySeriesDto::class,
        NowPlayingMovieDto::class,
        OnTheAirSeriesDto::class,
        UpcomingMovieDto::class,
        PopularMovieDto::class,
        PopularSeriesDto::class,
        TopRatedSeriesDto::class,
        TopRatedMovieDto::class,
        UserDto::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun userDao(): UserDao
}