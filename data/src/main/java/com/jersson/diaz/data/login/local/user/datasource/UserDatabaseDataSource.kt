package com.jersson.diaz.data.login.local.user.datasource

import com.jersson.diaz.data.login.local.user.LosAndesDataBase
import com.jersson.diaz.data.login.local.user.model.DbUser

class UserDatabaseDataSource(
    private val losAndesDataBase: LosAndesDataBase
) {
    suspend fun insertUser(dbUser: DbUser) = losAndesDataBase.userDao().insertUser(dbUser)
}