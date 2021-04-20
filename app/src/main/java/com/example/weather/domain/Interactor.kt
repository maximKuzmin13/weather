package com.example.weather.domain

import com.example.weather.data.TempItem

interface Interactor {
    suspend fun insert(temp: List<TempItem>)
    suspend fun getWeekTemp(onSuccess: (List<TempItem>) -> Unit, onFail: (Throwable?) -> Unit)
}