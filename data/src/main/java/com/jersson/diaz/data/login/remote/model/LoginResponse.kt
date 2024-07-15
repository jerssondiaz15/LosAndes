package com.jersson.diaz.data.login.remote.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data") val data: Data?
)

data class Data(
    @SerializedName("accessToken") val accessToken: String,
    @SerializedName("expiresIn") val expiresIn: String,
    @SerializedName("tokenType") val tokenType: String,
    @SerializedName("user") val user: UserResponse
)

data class UserResponse(
    @SerializedName("_id") val id: String,
    @SerializedName("rbac") val rbac: RBAC,
    @SerializedName("profile") val profile: Profile
)

data class RBAC(
    @SerializedName("role") val role: String,
    @SerializedName("template") val template: String
)

data class ErrorResponse(
    @SerializedName("error") val error: ErrorDetail
)

data class ErrorDetail(
    @SerializedName("info") val info: String,
    @SerializedName("code") val code: Int,
    @SerializedName("userMessage") val userMessage: UserMessage
)

data class UserMessage(
    @SerializedName("original") val original: String,
    @SerializedName("es") val es: String,
    @SerializedName("ja") val ja: String
)