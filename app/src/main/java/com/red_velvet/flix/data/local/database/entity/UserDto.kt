package com.red_velvet.flix.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "USERS")
data class UserDto(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val userName: String,
    val name: String,
    val imageUrl: String,
)
