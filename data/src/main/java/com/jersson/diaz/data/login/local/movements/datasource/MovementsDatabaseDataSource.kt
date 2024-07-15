package com.jersson.diaz.data.login.local.movements.datasource

import com.jersson.diaz.data.login.local.movements.model.DbMovements
import com.jersson.diaz.data.login.local.user.LosAndesDataBase

class MovementsDatabaseDataSource(
    private val losAndesDataBase: LosAndesDataBase
) {
    suspend fun getListDbMovements(numAccount: String): List<DbMovements> = losAndesDataBase.movementsDao().getListDbMovements(numAccount)

    suspend fun insertMovements(dbMovie: DbMovements) = losAndesDataBase.movementsDao().insertMovements(dbMovie)
}