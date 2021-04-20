package com.example.weather.domain


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {
    @GET("data/2.5/onecall?lat=60.99&lon=30.9&exclude=hourly,minutely")
    fun list(@Query("appid") appId: String, @Query("units") units: String): Call<TemperatureWrapper>
}