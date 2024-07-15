package com.jersson.diaz.domain.model

data class LoginResponse(
    val data: Data?
)

data class Data(
    val accessToken: String,
    val expiresIn: String,
    val tokenType: String,
    val user: UserDomain
)

data class UserDomain(
    val _id: String,
    val rbac: Rbac,
    val profile: Profile
)

data class Rbac(
    val role: String,
    val template: String
)

data class ErrorResponse(
    val error: ErrorDetails
)

data class ErrorDetails(
    val info: String,
    val code: Int,
    val userMessage: UserMessage
)

data class UserMessage(
    val original: String,
    val es: String,
    val ja: String
)