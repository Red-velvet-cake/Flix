package com.red_velvet.flix.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieEntity
import com.red_velvet.flix.data.local.database.entity.PopularMovieEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieEntity
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovies(popularMovieEntities: List<PopularMovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedMovies(topRatedMovieEntities: List<TopRatedMovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNowPlayingMovies(nowPlayingMovieEntities: List<NowPlayingMovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpcomingMovies(upcomingMovieEntities: List<UpcomingMovieEntity>)

    @Query("SELECT * FROM PopularMovieEntity")
    fun getPopularMovies(): Flow<List<PopularMovieEntity>>

    @Query("SELECT * FROM TopRatedMovieEntity")
    fun getTopRatedMovies(): Flow<List<TopRatedMovieEntity>>

    @Query("SELECT * FROM NowPlayingMovieEntity")
    fun getNowPlayingMovies(): Flow<List<NowPlayingMovieEntity>>

    @Query("SELECT * FROM UpcomingMovieEntity")
    fun getUpcomingMovies(): Flow<List<UpcomingMovieEntity>>

}