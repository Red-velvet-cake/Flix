package com.red_velvet.flix.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.red_velvet.flix.data.local.database.entity.AiringTodayTvShowEntity
import com.red_velvet.flix.data.local.database.entity.OnTheAirTvShowEntity
import com.red_velvet.flix.data.local.database.entity.PopularTvShowEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedTvShowEntity
import kotlinx.coroutines.flow.Flow
@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularTvShows(popularTvShowEntities: List<PopularTvShowEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedTvShows(topRatedTvShowEntities: List<TopRatedTvShowEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOnTheAirTvShows(onTheAirTvShowEntities: List<OnTheAirTvShowEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAiringTodayTvShows(airingTodayTvShowEntities: List<AiringTodayTvShowEntity>)

    @Query("SELECT * FROM PopularTvShowEntity")
    fun getPopularTvShow(): Flow<List<PopularTvShowEntity>>

    @Query("SELECT * FROM TopRatedTvShowEntity")
    fun getTopRatedTvShow(): Flow<List<TopRatedTvShowEntity>>

    @Query("SELECT * FROM OnTheAirTvShowEntity")
    fun getOnTheAirTvShow(): Flow<List<OnTheAirTvShowEntity>>

    @Query("SELECT * FROM AiringTodayTvShowEntity")
    fun getAiringTodayTvShow(): Flow<List<AiringTodayTvShowEntity>>
}