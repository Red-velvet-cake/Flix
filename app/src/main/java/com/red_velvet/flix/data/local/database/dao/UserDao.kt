package com.red_velvet.flix.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.red_velvet.flix.data.local.database.entity.UserDto

@Dao
interface UserDao {
    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    suspend fun insertUserData(userDto: UserDto)

    @Query("SELECT * FROM USERS")
    suspend fun getUserData(): UserDto
}