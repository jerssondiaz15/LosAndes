package com.jersson.diaz.losandes.model

data class MutableUiStateHolder(override var currentState: UiState = UiState.INIT) : UiStateHolder