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
interface SeriesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularTvShows(popularTvShowEntities: List<PopularSeriesDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedTvShows(topRatedTvShowEntities: List<TopRatedSeriesDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOnTheAirTvShows(onTheAirTvShowEntities: List<OnTheAirSeriesDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAiringTodayTvShows(airingTodayTvShowEntities: List<AiringTodaySeriesDto>)

    @Query("SELECT * FROM POPULAR_SERIES")
    fun getPopularSeries(): List<PopularSeriesDto>

    @Query("SELECT * FROM TOP_RATED_SERIES")
    fun getTopRatedSeries(): List<TopRatedSeriesDto>

    @Query("SELECT * FROM ON_THE_AIR_SERIES")
    fun getOnTheAirSeries(): List<OnTheAirSeriesDto>

    @Query("SELECT * FROM AIRING_TODAY_SERIES")
    fun getAiringTodaySeries(): List<AiringTodaySeriesDto>
}