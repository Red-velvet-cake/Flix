package com.red_velvet.flix.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.red_velvet.flix.data.local.database.entity.AiringTodayTvShowEntity
import com.red_velvet.flix.data.local.database.entity.OnTheAirTvShowEntity
import com.red_velvet.flix.data.local.database.entity.PopularTvShowEntity
import com.red_velvet.flix.data.local.database.entity.TopRatedTvShowEntity

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

    @Query("SELECT * FROM popular_tv_shows")
    fun getPopularTvShow(): List<PopularTvShowEntity>

    @Query("SELECT * FROM top_rated_series")
    fun getTopRatedTvShow(): List<TopRatedTvShowEntity>

    @Query("SELECT * FROM on_the_air_series")
    fun getOnTheAirTvShow(): List<OnTheAirTvShowEntity>

    @Query("SELECT * FROM airing_today_series")
    fun getAiringTodayTvShow(): List<AiringTodayTvShowEntity>
}