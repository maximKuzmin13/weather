package com.example.weather.data

import androidx.lifecycle.LiveData
import com.example.weather.core.MyApp
import com.example.weather.domain.MainApi
import com.example.weather.domain.MainRepository
import com.example.weather.domain.TemperatureWrapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepositoryImpl(private val tempDao: TempDao, private val api: MainApi): MainRepository {

    private val tempList: LiveData<List<TempItem>> = tempDao.getAll()

    override fun insert(temp: List<TempItem>) {
        tempDao.insert(temp)
    }

    override fun getAll() : LiveData<List<TempItem>> {
        return tempList;
    }

    override fun getWeekTemp(onSuccess: (List<TempItem>) -> Unit,
                             onFail: (Throwable?) -> Unit) {
        val temperatureWrapper = api.list(MyApp.API_KEY, "metric")

        temperatureWrapper.enqueue(object : Callback<TemperatureWrapper> {
            override fun onResponse(
                    call: Call<TemperatureWrapper>?,
                    response: Response<TemperatureWrapper>?
            ) {
                val temperature = response?.body()
                temperature?.temp?.map {
                    TempItem(day = it.dayliTemp.day, id = 0)
                }?.let { onSuccess(it) }
            }

            override fun onFailure(call: Call<TemperatureWrapper>?, t: Throwable?) {
                onFail(t)
            }
        })

    }
}