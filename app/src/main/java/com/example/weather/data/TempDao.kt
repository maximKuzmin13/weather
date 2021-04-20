package com.example.weather.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TempDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(temp: List<TempItem>)

    @Query("SELECT * FROM weather_table ")
    fun getAll(): LiveData<List<TempItem>>
}