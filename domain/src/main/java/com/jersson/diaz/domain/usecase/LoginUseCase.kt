package com.jersson.diaz.domain.usecase

import com.jersson.diaz.domain.model.ErrorResponse
import com.jersson.diaz.domain.model.LoginResponse
import com.jersson.diaz.domain.model.ResultType
import com.jersson.diaz.domain.model.User
import com.jersson.diaz.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(user: User): ResultType<LoginResponse?, ErrorResponse> {
        return authRepository.login(user)
    }
}