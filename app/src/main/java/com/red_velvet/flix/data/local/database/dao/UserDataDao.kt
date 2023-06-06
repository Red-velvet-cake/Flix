package com.red_velvet.flix.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.red_velvet.flix.data.local.database.entity.UserEntity

@Dao
interface UserDataDao {
    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    suspend fun insertUserData(userEntity: UserEntity)

    @Query("SELECT * FROM users")
    suspend fun getUserData(): UserEntity
}