package com.example.weather.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TempItem::class], version = 1)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDao() : TempDao
}