package com.weatherApp.data.db


//TODO define WeatherEntity as a Room entity

data class WeatherEntity(
    val id: Int,
    val time: String,
    val temperature: Double
)
