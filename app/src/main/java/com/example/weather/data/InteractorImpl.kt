package com.example.weather.data

import com.example.weather.domain.Interactor
import com.example.weather.domain.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InteractorImpl(private val repository: MainRepository) : Interactor {
    override suspend fun getWeekTemp(onSuccess: (List<TempItem>) -> Unit, onFail: (Throwable?) -> Unit) {
        return try {
            withContext(Dispatchers.IO){
                repository.getWeekTemp(onSuccess, onFail)
                }
            } catch (e: Exception){
            onFail(e)
        }
    }
}