package com.jersson.diaz.domain.repository

interface UserRepository {
    suspend fun insertUser(id: Int, accessToken: String, expiresIn: String)
}