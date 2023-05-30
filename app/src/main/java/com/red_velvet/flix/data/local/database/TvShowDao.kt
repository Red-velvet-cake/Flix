package com.red_velvet.flix.data.local.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.red_velvet.flix.data.local.database.entity.AirngTodayTvShowEntity
import com.red_velvet.flix.data.local.database.entity.OnTheAirTvShowEntity
import com.red_velvet.flix.data.local.database.entity.PopularTvShowEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedTvShowEntity
import kotlinx.coroutines.flow.Flow

interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularTvShow(popularTvShowEntity: PopularTvShowEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedTvShow(topRatedTvShowEntity: TopRatedTvShowEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOnTheAirTvShow(onTheAirTvShowEntity: OnTheAirTvShowEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAiringTodayTvShow(airngTodayTvShowEntity: AirngTodayTvShowEntity)

    @Query("SELECT * FROM PopularTvShowEntity")
    fun getPopularTvShow(): Flow<List<PopularTvShowEntity>>

    @Query("SELECT * FROM TopRatedTvShowEntity")
    fun getTopRatedTvShow(): Flow<List<TopRatedTvShowEntity>>

    @Query("SELECT * FROM OnTheAirTvShowEntity")
    fun getOnTheAirTvShow(): Flow<List<OnTheAirTvShowEntity>>

    @Query("SELECT * FROM AirngTodayTvShowEntity")
    fun getAiringTodayTvShow(): Flow<List<AirngTodayTvShowEntity>>
}