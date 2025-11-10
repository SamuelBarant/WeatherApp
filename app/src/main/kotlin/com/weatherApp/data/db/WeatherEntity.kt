package com.weatherApp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey


//TODO define WeatherEntity as a Room entity

@Entity(tableName = "weather_data")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val time: String,
    val temperature: Double
)
