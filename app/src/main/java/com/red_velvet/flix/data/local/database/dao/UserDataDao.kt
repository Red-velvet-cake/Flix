package com.red_velvet.flix.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.red_velvet.flix.data.local.database.entity.FavoriteMovieDto
import com.red_velvet.flix.data.local.database.entity.FavoriteSeriesDto
import com.red_velvet.flix.data.local.database.entity.UserEntity
import com.red_velvet.flix.data.local.database.entity.WatchedMovieDto
import com.red_velvet.flix.data.local.database.entity.WatchedSeriesDto

@Dao
interface UserDataDao {
    @Insert
    suspend fun insertUserData(userEntity: UserEntity)

    @Query("SELECT * FROM UserEntity")
    suspend fun getUserData(): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFavoriteMovies(favoriteMovies: List<FavoriteMovieDto>)

    @Query("SELECT * FROM favorite_movies")
    suspend fun getAllFavoriteMovies(): List<FavoriteMovieDto>

    @Query("DELETE FROM favorite_movies")
    suspend fun deleteAllFavoriteMovies()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFavoriteSeries(favoriteSeries: List<FavoriteSeriesDto>)

    @Query("SELECT * FROM favorite_series")
    suspend fun getAllFavoriteSeries(): List<FavoriteSeriesDto>

    @Query("DELETE FROM favorite_series")
    suspend fun deleteAllFavoriteSeries()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllWatchedMovies(watchedMovies: List<WatchedMovieDto>)

    @Query("SELECT * FROM watched_movies")
    suspend fun getAllWatchedMovies(): List<WatchedMovieDto>

    @Query("DELETE FROM watched_movies")
    suspend fun deleteAllWatchedMovies()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllWatchedSeries(watchedSeries: List<WatchedSeriesDto>)

    @Query("SELECT * FROM watched_series")
    suspend fun getAllWatchedSeries(): List<WatchedSeriesDto>

    @Query("DELETE FROM watched_series")
    suspend fun deleteAllWatchedSeries()
}