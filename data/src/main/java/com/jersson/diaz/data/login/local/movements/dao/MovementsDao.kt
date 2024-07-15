package com.jersson.diaz.data.login.local.movements.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jersson.diaz.data.login.local.movements.model.DbMovements

@Dao
interface MovementsDao {

    @Query("SELECT * FROM movements WHERE numAccount = :numAccount")
    suspend fun getListDbMovements(numAccount: String): List<DbMovements>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovements(dbMovie: DbMovements)
}