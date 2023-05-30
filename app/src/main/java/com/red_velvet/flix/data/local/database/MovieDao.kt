package com.red_velvet.flix.data.local.database

import androidx.room.Insert
import androidx.room.Query
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieEntity
import com.red_velvet.flix.data.local.database.entity.PopularMovieEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieEntity
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieDao {
    @Insert
    suspend fun insertPopularMovie(popularMovieEntity: PopularMovieEntity)

    @Insert
    suspend fun insertTopRatedMovie(topRatedMovieEntity: TopRatedMovieEntity)

    @Insert
    suspend fun insertNowPlayingMovie(nowPlayingMovieEntity: NowPlayingMovieEntity)

    @Insert
    suspend fun insertUpcomingMovie(popularMovieEntity: PopularMovieEntity)

    @Query("SELECT * FROM PopularMovieEntity")
    fun getPopularTvShow(): Flow<List<PopularMovieEntity>>

    @Query("SELECT * FROM TopRatedMovieEntity")
    fun getTopRatedTvShow(): Flow<List<TopRatedMovieEntity>>

    @Query("SELECT * FROM NowPlayingMovieEntity")
    fun getOnTheAirTvShow(): Flow<List<NowPlayingMovieEntity>>

    @Query("SELECT * FROM UpcomingMovieEntity")
    fun getAiringTodayTvShow(): Flow<List<UpcomingMovieEntity>>

}