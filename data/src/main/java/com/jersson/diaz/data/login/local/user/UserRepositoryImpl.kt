package com.jersson.diaz.data.login.local.user

import com.jersson.diaz.data.login.local.user.datasource.UserDatabaseDataSource
import com.jersson.diaz.data.login.local.user.model.DbUser
import com.jersson.diaz.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDatabaseDataSource: UserDatabaseDataSource
): UserRepository {
    override suspend fun insertUser(id: Int, accessToken: String, expiresIn: String) {
        val dbUser = DbUser(
            id = id,
            accessToken = accessToken,
            expiresIn = expiresIn
        )
        userDatabaseDataSource.insertUser(dbUser)
    }
}