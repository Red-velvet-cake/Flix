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
    suspend fun insertPopularSeries(popularSeries: List<PopularSeriesDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedSeries(topRatedSeries: List<TopRatedSeriesDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOnTheAirSeries(onTheAirSeries: List<OnTheAirSeriesDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAiringTodaySeries(airingTodaySeries: List<AiringTodaySeriesDto>)

    @Query("SELECT * FROM POPULAR_SERIES")
    suspend fun getPopularSeries(): List<PopularSeriesDto>

    @Query("SELECT * FROM TOP_RATED_SERIES")
    suspend fun getTopRatedSeries(): List<TopRatedSeriesDto>

    @Query("SELECT * FROM ON_THE_AIR_SERIES")
    suspend fun getOnTheAirSeries(): List<OnTheAirSeriesDto>

    @Query("SELECT * FROM AIRING_TODAY_SERIES")
    suspend fun getAiringTodaySeries(): List<AiringTodaySeriesDto>
}