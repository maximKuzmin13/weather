package com.example.weather.domain

import com.example.weather.data.TempItem

interface Interactor {
    suspend fun getWeekTemp(onSuccess: (List<TempItem>) -> Unit, onFail: (Throwable?) -> Unit)
}