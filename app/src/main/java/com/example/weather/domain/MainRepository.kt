package com.example.weather.domain

import com.example.weather.data.TempItem

interface MainRepository {
    suspend fun getWeekTemp(onSuccess: (List<TempItem>) -> Unit, onFail: (Throwable?) -> Unit)
}