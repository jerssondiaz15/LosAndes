package com.jersson.diaz.data.login.local.user.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "user"
)
data class DbUser(
    @PrimaryKey(autoGenerate = true) val code: Int = 0,
    val id: String = "",
    val accessToken: String,
    val expiresIn: String,
)