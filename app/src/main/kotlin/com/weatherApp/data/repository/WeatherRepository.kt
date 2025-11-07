package com.weatherApp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.weatherApp.data.api.WeatherApiService
import com.weatherApp.data.db.WeatherDao
import com.weatherApp.data.db.WeatherEntity
import com.weatherApp.utils.PreferencesManager
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WeatherRepository(
    //private val dao: WeatherDao,
    private val api: WeatherApiService,
    private val prefs: PreferencesManager
) {

    fun getSavedLocation(): Triple<String?, Float?, Float?> {
        val name = prefs.getCityName()
        val latitude = prefs.getLatitude()
        val longitude = prefs.getLongitude()
        return Triple(name,latitude,longitude)
    }

    fun saveLocation(name: String,latitude: Double,longitude: Double, ) {
        prefs.saveLocation(name,latitude,longitude)
    }

    suspend fun fetchWeather(latitude: Float?, longitude: Float?) {
        val response = api.getWeather(latitude, longitude)
        val temperatures = response.hourly.temperature_2m.mapIndexed { index, temp ->
            WeatherEntity(
                id = 0,
                temperature = temp,
                time = response.hourly.time[index]
            )
        }
        //dao.clearDatabase()
        //dao.insertWeatherData(temperatures)
    }

    fun getWeather(): LiveData<List<WeatherEntity>> {
        // TODO uncomment when DAO is defined and delete all the other lines on this function
        //  return dao.retrieveWeatherData()
        val mockData = MutableLiveData<List<WeatherEntity>>()

        val now = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")

        val list = List(12) { i ->
            WeatherEntity(
                id = i,
                temperature = (10..25).random().toDouble(),
                time = now.plusHours(i.toLong()).format(formatter)
            )
        }

        mockData.value = list
        return mockData
    }
}

