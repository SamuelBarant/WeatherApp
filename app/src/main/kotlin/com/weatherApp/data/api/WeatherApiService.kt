package com.weatherApp.data.api

import retrofit2.http.GET
import retrofit2.http.Query

data class WeatherResponse(
    val hourly: HourlyData = HourlyData()
)

data class HourlyData(
    val temperature_2m: List<Double> = emptyList(),
    val time: List<String> = emptyList()
)


interface WeatherApiService {
    @GET("v1/forecast")
    suspend fun getWeather(
        @Query("latitude") latitude: Float?,
        @Query("longitude") longitude: Float?,
        @Query("hourly") hourly: String = "temperature_2m",
        @Query("timezone") timezone:String = "Europe/Berlin",
        @Query("forecast_days") forecastDays: Int = 1
    ): WeatherResponse
}
