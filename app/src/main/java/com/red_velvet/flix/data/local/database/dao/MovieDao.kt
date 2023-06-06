package com.red_velvet.flix.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieDto
import com.red_velvet.flix.data.local.database.entity.PopularMovieDto
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieDto
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieDto
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovies(popularMovieEntities: List<PopularMovieDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedMovies(topRatedMovieEntities: List<TopRatedMovieDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNowPlayingMovies(nowPlayingMovieEntities: List<NowPlayingMovieDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpcomingMovies(upcomingMovieEntities: List<UpcomingMovieDto>)

    @Query("SELECT * FROM POPULAR_MOVIES")
    fun getPopularMovies(): Flow<List<PopularMovieDto>>

    @Query("SELECT * FROM TOP_RATED_MOVIES")
    fun getTopRatedMovies(): Flow<List<TopRatedMovieDto>>

    @Query("SELECT * FROM NOW_PLAYING_MOVIES")
    fun getNowPlayingMovies(): Flow<List<NowPlayingMovieDto>>

    @Query("SELECT * FROM UPCOMING_MOVIES")
    fun getUpcomingMovies(): Flow<List<UpcomingMovieDto>>

}