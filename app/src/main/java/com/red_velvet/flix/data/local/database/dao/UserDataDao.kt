package com.red_velvet.flix.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.red_velvet.flix.data.local.database.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDataDao {
    @Insert
    suspend fun insertUserData(userEntity: UserEntity)

    @Query("SELECT * FROM UserEntity")
    fun getUserData(): Flow<UserEntity>
}