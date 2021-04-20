package com.example.weather.domain

import com.google.gson.annotations.SerializedName

data class TemperatureWrapper(
        @SerializedName("daily")
        var temp: List<Temp>,
        )

data class Temp(
        @SerializedName("temp")
        var dayliTemp : TemperatureData)

data class TemperatureData(
        @SerializedName("day") val day: Double,
        @SerializedName("min") val min: Double,
        @SerializedName("max") val max: Double,
)