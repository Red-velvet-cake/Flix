package com.red_velvet.flix.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.red_velvet.flix.data.local.database.dao.MovieDao
import com.red_velvet.flix.data.local.database.dao.TvShowDao
import com.red_velvet.flix.data.local.database.dao.UserDao
import com.red_velvet.flix.data.local.database.entity.AiringTodayTvShowEntity
import com.red_velvet.flix.data.local.database.entity.FavoriteMovieDto
import com.red_velvet.flix.data.local.database.entity.FavoriteSeriesDto
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieEntity
import com.red_velvet.flix.data.local.database.entity.OnTheAirTvShowEntity
import com.red_velvet.flix.data.local.database.entity.PopularMovieEntity
import com.red_velvet.flix.data.local.database.entity.PopularTvShowEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedTvShowEntity
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieEntity
import com.red_velvet.flix.data.local.database.entity.UserEntity
import com.red_velvet.flix.data.local.database.entity.WatchedMovieDto
import com.red_velvet.flix.data.local.database.entity.WatchedSeriesDto

@Database(
    entities = [
        AiringTodayTvShowEntity::class,
        NowPlayingMovieEntity::class,
        OnTheAirTvShowEntity::class,
        UpcomingMovieEntity::class,
        PopularMovieEntity::class,
        PopularTvShowEntity::class,
        TopRatedTvShowEntity::class,
        TopRatedMovieEntity::class,
        UserEntity::class,
        FavoriteMovieDto::class,
        FavoriteSeriesDto::class,
        WatchedMovieDto::class,
        WatchedSeriesDto::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun userDao(): UserDao
}