package com.example.weather.domain

import androidx.lifecycle.LiveData
import com.example.weather.data.TempItem

interface MainRepository {
    fun getWeekTemp(onSuccess: (List<TempItem>) -> Unit, onFail: (Throwable?) -> Unit)
    fun getAll(): LiveData<List<TempItem>>
    fun insert(temp: List<TempItem>)
}