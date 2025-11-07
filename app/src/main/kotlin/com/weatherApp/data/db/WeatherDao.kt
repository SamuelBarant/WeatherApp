package com.weatherApp.data.db

import androidx.lifecycle.LiveData

//TODO define WeatherDao interface
/**
 * It needs three functions:
 * insertWeatherData: inserts a list of WeatherEntity values.
 * retrieveWeatherData: gets all the data stored on the weather_data table,
 * ordered by time (ascending).
 * clearDatabase: deletes all the data on the weather_data table
 */

interface WeatherDao {
    suspend fun insertWeatherData(data: List<WeatherEntity>)
    fun retrieveWeatherData(): LiveData<List<WeatherEntity>>
    suspend fun clearDatabase()
}
