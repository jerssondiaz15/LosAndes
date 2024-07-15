package com.jersson.diaz.data.login.local.user.dao

import androidx.room.Dao
import androidx.room.Insert
import com.jersson.diaz.data.login.local.user.model.DbUser

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(dbUser: DbUser)
}