package com.jersson.diaz.domain.repository

interface UserRepository {
    suspend fun insertUser(id: String, accessToken: String, expiresIn: String)
}