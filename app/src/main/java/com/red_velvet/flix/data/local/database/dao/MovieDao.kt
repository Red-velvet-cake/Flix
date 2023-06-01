package com.red_velvet.flix.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieEntity
import com.red_velvet.flix.data.local.database.entity.PopularMovieEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieEntity
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieEntity
import kotlinx.coroutines.flow.Flow
@Dao
interface MovieDao {
    @Insert
    suspend fun insertPopularMovie(popularMovieEntity: List<PopularMovieEntity>)

    @Insert
    suspend fun insertTopRatedMovie(topRatedMovieEntity: List<TopRatedMovieEntity>)

    @Insert
    suspend fun insertNowPlayingMovie(nowPlayingMovieEntity: List<NowPlayingMovieEntity>)

    @Insert
    suspend fun insertUpcomingMovie(popularMovieEntity: List<PopularMovieEntity>)

    @Query("SELECT * FROM PopularMovieEntity")
    fun getPopularTvShow(): Flow<List<PopularMovieEntity>>

    @Query("SELECT * FROM TopRatedMovieEntity")
    fun getTopRatedTvShow(): Flow<List<TopRatedMovieEntity>>

    @Query("SELECT * FROM NowPlayingMovieEntity")
    fun getOnTheAirTvShow(): Flow<List<NowPlayingMovieEntity>>

    @Query("SELECT * FROM UpcomingMovieEntity")
    fun getAiringTodayTvShow(): Flow<List<UpcomingMovieEntity>>

}