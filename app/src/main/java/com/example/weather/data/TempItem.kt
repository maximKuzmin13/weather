package com.example.weather.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class TempItem (
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        @ColumnInfo(name = "day")
        val day : Double
        )