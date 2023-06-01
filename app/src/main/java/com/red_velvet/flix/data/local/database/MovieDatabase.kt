package com.red_velvet.flix.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.red_velvet.flix.data.local.database.dao.MovieDao
import com.red_velvet.flix.data.local.database.dao.TvShowDao
import com.red_velvet.flix.data.local.database.dao.UserDataDao
import com.red_velvet.flix.data.local.database.entity.AiringTodayTvShowEntity
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieEntity
import com.red_velvet.flix.data.local.database.entity.OnTheAirTvShowEntity
import com.red_velvet.flix.data.local.database.entity.PopularMovieEntity
import com.red_velvet.flix.data.local.database.entity.PopularTvShowEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedTvShowEntity
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieEntity
import com.red_velvet.flix.data.local.database.entity.UserEntity

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
        UserEntity::class
    ], version = 1
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun userDataDao(): UserDataDao
}