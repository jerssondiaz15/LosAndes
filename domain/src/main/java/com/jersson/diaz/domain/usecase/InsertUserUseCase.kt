package com.jersson.diaz.domain.usecase

import com.jersson.diaz.domain.repository.UserRepository
import javax.inject.Inject

class InsertUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(id: Int, accessToken: String, expiresIn: String) = userRepository.insertUser(id, accessToken, expiresIn)
}