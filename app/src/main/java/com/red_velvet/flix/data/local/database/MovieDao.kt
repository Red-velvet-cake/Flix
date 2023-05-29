package com.red_velvet.flix.data.local.database

import androidx.room.Insert
import androidx.room.Query
import com.red_velvet.flix.data.local.database.entity.MovieEntity
import com.red_velvet.flix.data.local.database.entity.TvShow
import kotlinx.coroutines.flow.Flow

interface MovieDao {
    @Insert
    suspend fun insertMovie(movie:MovieEntity)
    @Insert
    suspend fun insertAllMovies(movie: List<MovieEntity>)
    @Query("select * from MovieEntity")
    fun getMovie(): Flow<MovieEntity>
    @Insert
    suspend fun insertTvShow(tvShow: TvShow)
    @Insert
    suspend fun insertAllTvShow(movie: List<TvShow>)
    @Query("select * from TvShow")
    fun getTvShow(): Flow<TvShow>
}