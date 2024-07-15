package com.jersson.diaz.domain.repository

import com.jersson.diaz.domain.model.ErrorResponse
import com.jersson.diaz.domain.model.LoginResponse
import com.jersson.diaz.domain.model.ResultType
import com.jersson.diaz.domain.model.User

interface AuthRepository {
    suspend fun login(user: User): ResultType<LoginResponse?, ErrorResponse>
}