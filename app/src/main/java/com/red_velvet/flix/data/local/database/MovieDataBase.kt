package com.red_velvet.flix.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.red_velvet.flix.data.local.database.entity.MovieEntity
import com.red_velvet.flix.data.local.database.entity.TvShow

@Database( entities = [MovieEntity::class , TvShow::class] , version = 1)
abstract class MovieDataBase : RoomDatabase(){
abstract fun movieDao() : MovieDao
companion object{
    const val DATABASE_NAME = "MovieDatabase"
}
}