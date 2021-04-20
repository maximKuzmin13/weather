package com.example.weather.core

sealed class ViewState {

    object Loading : ViewState()

    object Success : ViewState()

    data class Error(
            val message: String?
    ) : ViewState()
}