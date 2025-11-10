package com.weatherApp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//TODO define WeatherDao interface
/**
 * It needs three functions:
 * insertWeatherData: inserts a list of WeatherEntity values.
 * retrieveWeatherData: gets all the data stored on the weather_data table,
 * ordered by time (ascending).
 * clearDatabase: deletes all the data on the weather_data table
 */

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherData(data: List<WeatherEntity>)

    @Query("SELECT * FROM weather_data ORDER BY time ASC")
    fun retrieveWeatherData(): LiveData<List<WeatherEntity>>

    @Query("DELETE FROM weather_data")
    suspend fun clearDatabase()
}
