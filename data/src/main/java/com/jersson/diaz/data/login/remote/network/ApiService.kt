package com.jersson.diaz.data.login.remote.network

import com.jersson.diaz.data.login.remote.model.LoginRequest
import com.jersson.diaz.data.login.remote.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers(
        "Content-Type: application/json",
        "Authorization: Basic cHJ1ZWJhc2RldjpwcnVlYmFzZGV2U2VjcmV0"
    )
    @POST("auth/users/login/anonymous")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>
}