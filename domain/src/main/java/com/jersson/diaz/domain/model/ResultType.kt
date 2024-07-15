package com.jersson.diaz.domain.model

import androidx.annotation.Keep

@Keep
sealed class ResultType<T, U> {

    data class Success<T, U>(val value: T) : ResultType<T, U>()

    data class Error<T, U>(val value: U) : ResultType<T, U>()
}