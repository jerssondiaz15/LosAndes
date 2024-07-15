package com.jersson.diaz.domain.model

class User(
    val user: String = "",
    val password: String = "",
    val profile: Profile = Profile("es")
)

data class Profile(
    val language: String
)