package com.jersson.diaz.data.login.local.accounts.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jersson.diaz.data.login.local.accounts.model.DbAccounts

@Dao
interface AccountsDao {

    @Query("SELECT * FROM accounts")
    suspend fun getListDbAccounts(): List<DbAccounts>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAccounts(dbMovie: DbAccounts)
}