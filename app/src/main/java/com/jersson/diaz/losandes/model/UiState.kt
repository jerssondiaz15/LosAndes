package com.jersson.diaz.losandes.model

enum class UiState {
    INIT,
    LOADING,
    EMPTY,
    SUCCESS,
    ERROR;

    companion object {

        @JvmStatic
        fun from(quantity: Int): UiState = if(quantity == 0) EMPTY else SUCCESS

        @JvmStatic
        fun from(list: List<*>): UiState = if(list.isEmpty()) EMPTY else SUCCESS
    }
}