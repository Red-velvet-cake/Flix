package com.red_velvet.flix.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieDto
import com.red_velvet.flix.data.local.database.entity.PopularMovieDto
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieDto
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieDto

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovies(popularMovies: List<PopularMovieDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedMovies(topRatedMovies: List<TopRatedMovieDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNowPlayingMovies(nowPlayingMovies: List<NowPlayingMovieDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpcomingMovies(upcomingMovies: List<UpcomingMovieDto>)

    @Query("SELECT * FROM POPULAR_MOVIES")
    suspend fun getPopularMovies(): List<PopularMovieDto>

    @Query("SELECT * FROM TOP_RATED_MOVIES")
    suspend fun getTopRatedMovies(): List<TopRatedMovieDto>

    @Query("SELECT * FROM NOW_PLAYING_MOVIES")
    suspend fun getNowPlayingMovies(): List<NowPlayingMovieDto>

    @Query("SELECT * FROM UPCOMING_MOVIES")
    suspend fun getUpcomingMovies(): List<UpcomingMovieDto>

}