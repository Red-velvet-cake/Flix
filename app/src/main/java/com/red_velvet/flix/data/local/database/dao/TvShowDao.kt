package com.red_velvet.flix.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.red_velvet.flix.data.local.database.entity.AiringTodaySeriesDto
import com.red_velvet.flix.data.local.database.entity.OnTheAirSeriesDto
import com.red_velvet.flix.data.local.database.entity.PopularSeriesDto
import com.red_velvet.flix.data.local.database.entity.TopRatedSeriesDto

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularTvShows(popularTvShowEntities: List<PopularSeriesDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedTvShows(topRatedTvShowEntities: List<TopRatedSeriesDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOnTheAirTvShows(onTheAirTvShowEntities: List<OnTheAirSeriesDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAiringTodayTvShows(airingTodayTvShowEntities: List<AiringTodaySeriesDto>)

    @Query("SELECT * FROM POPULAR_SERIES")
    fun getPopularTvShow(): List<PopularSeriesDto>

    @Query("SELECT * FROM TOP_RATED_SERIES")
    fun getTopRatedTvShow(): List<TopRatedSeriesDto>

    @Query("SELECT * FROM ON_THE_AIR_SERIES")
    fun getOnTheAirTvShow(): List<OnTheAirSeriesDto>

    @Query("SELECT * FROM AIRING_TODAY_SERIES")
    fun getAiringTodayTvShow(): List<AiringTodaySeriesDto>
}