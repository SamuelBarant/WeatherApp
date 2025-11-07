package com.weatherApp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weatherApp.data.db.WeatherEntity
import kotlinx.coroutines.launch
import com.weatherApp.data.repository.WeatherRepository

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    fun refreshWeather(lat: Float?, lon: Float?) {
        viewModelScope.launch {
            repository.fetchWeather(lat, lon)
        }
    }

    fun getWeather(): LiveData<List<WeatherEntity>> {
        return repository.getWeather()
    }

    fun getLocation(): Triple<String?, Float?, Float?>{
        return repository.getSavedLocation()
    }
}
