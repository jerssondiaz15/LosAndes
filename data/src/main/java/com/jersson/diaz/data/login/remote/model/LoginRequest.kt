package com.jersson.diaz.data.login.remote.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("user") val user: User,
    @SerializedName("device") val device: Device,
    @SerializedName("app") val app: App
)

data class User(
    @SerializedName("usr_code") val userCode: String,
    @SerializedName("pass") val pass: String,
    @SerializedName("profile") val profile: Profile
)

data class Profile(
    @SerializedName("language") val language: String
)

data class Device(
    @SerializedName("deviceId") val deviceId: String,
    @SerializedName("name") val name: String,
    @SerializedName("version") val version: String,
    @SerializedName("width") val width: String,
    @SerializedName("height") val height: String,
    @SerializedName("model") val model: String,
    @SerializedName("platform") val platform: String
)

data class App(
    @SerializedName("version") val version: String
)