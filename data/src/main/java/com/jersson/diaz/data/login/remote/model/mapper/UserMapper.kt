package com.jersson.diaz.data.login.remote.model.mapper

import com.jersson.diaz.data.login.remote.model.ErrorResponse
import com.jersson.diaz.domain.model.Data
import com.jersson.diaz.domain.model.ErrorDetails
import com.jersson.diaz.domain.model.LoginResponse
import com.jersson.diaz.domain.model.Profile
import com.jersson.diaz.domain.model.Rbac
import com.jersson.diaz.domain.model.User
import com.jersson.diaz.domain.model.UserDomain
import com.jersson.diaz.domain.model.UserMessage
import com.jersson.diaz.data.login.remote.model.User as UserData
import com.jersson.diaz.data.login.remote.model.Profile as ProfileData
import com.jersson.diaz.data.login.remote.model.LoginResponse as LoginResponseData
import com.jersson.diaz.domain.model.ErrorResponse as ErrorResponseDomain

fun User.toData(): UserData = with(this) {
    UserData(
        userCode = user,
        pass = password,
        profile = ProfileData(
            language = profile.language
        )
    )
}

fun LoginResponseData.toDomain(): LoginResponse = with(this) {
    LoginResponse(
        data = Data(
            accessToken = data?.accessToken ?: "",
            expiresIn = data?.expiresIn ?: "",
            tokenType = data?.tokenType ?: "",
            user = UserDomain(
                _id = data?.user?.id ?: "",
                rbac = Rbac(
                    role = data?.user?.rbac?.role ?: "",
                    template = data?.user?.rbac?.template ?: ""
                ),
                profile = Profile(
                    data?.user?.profile?.language ?: "es"
                )
            )
        )
    )
}

fun ErrorResponse.toDomain(): ErrorResponseDomain = with(this) {
    ErrorResponseDomain(
        error = ErrorDetails(
            info = error.info,
            code = error.code,
            userMessage = UserMessage(
                original = error.userMessage.original,
                es = error.userMessage.es,
                ja = error.userMessage.ja,
            )
        )
    )
}