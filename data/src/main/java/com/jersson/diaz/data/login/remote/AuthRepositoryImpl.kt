package com.jersson.diaz.data.login.remote

import android.os.Build
import android.util.Log
import com.jersson.diaz.data.login.remote.model.App
import com.jersson.diaz.data.login.remote.model.Device
import com.jersson.diaz.data.login.remote.model.LoginRequest
import com.jersson.diaz.domain.model.UserMessage
import com.jersson.diaz.data.login.remote.model.mapper.toData
import com.jersson.diaz.data.login.remote.model.mapper.toDomain
import com.jersson.diaz.data.login.remote.network.ApiService
import com.jersson.diaz.domain.model.ErrorDetails
import com.jersson.diaz.domain.model.ErrorResponse
import com.jersson.diaz.domain.model.LoginResponse
import com.jersson.diaz.domain.model.ResultType
import com.jersson.diaz.domain.model.User
import com.jersson.diaz.domain.repository.AuthRepository
import retrofit2.HttpException
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
): AuthRepository {
    override suspend fun login(user: User): ResultType<LoginResponse?, ErrorResponse> {

        val dispositivo = if ("android" in Build.DEVICE.toLowerCase()) "Android" else "ios"

        val loginRequest = LoginRequest(
            user = user.toData(),
            device = Device(
                deviceId = "1234567",
                name = "MyPhone",
                version = "4.4.4",
                width = "640",
                height = "960",
                model = "Awesome Model 10",
                platform = dispositivo
            ),
            app = App(version = "1.0.0")
        )

        val response = apiService.login(loginRequest)
        return try {
            Log.i("Jersson", "$response")
            if (response.isSuccessful) {
                ResultType.Success(response.body()?.toDomain())
            } else {
                val error = ErrorDetails(
                    info = response.errorBody().toString(),
                    code = 1,
                    userMessage = UserMessage(
                        original = response.errorBody().toString(),
                        es = response.errorBody().toString(),
                        ja = response.errorBody().toString()
                    )
                )
                ResultType.Error(ErrorResponse(error))
            }
        } catch (e: HttpException) {
            val error = ErrorDetails(
                info = e.message(),
                code = e.code(),
                userMessage = UserMessage(
                    original = e.message(),
                    es = e.message(),
                    ja = e.message()
                )
            )
            ResultType.Error(ErrorResponse(error))
        } catch (e: Exception) {
            val error = ErrorDetails(
                info = e.message ?: "Exception",
                code = 2,
                userMessage = UserMessage(
                    original = e.message ?: "Exception",
                    es = e.message ?: "Exception",
                    ja = e.message ?: "Exception"
                )
            )
            ResultType.Error(ErrorResponse(error))
        }
    }
}