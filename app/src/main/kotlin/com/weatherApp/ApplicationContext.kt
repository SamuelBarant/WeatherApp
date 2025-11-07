package com.weatherApp

import android.app.Application
import com.weatherApp.data.api.WeatherApiService
import com.weatherApp.data.db.WeatherDatabase
import com.weatherApp.data.repository.WeatherRepository
import com.weatherApp.utils.PreferencesManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationContext : Application() {

    companion object {
        lateinit var instance: ApplicationContext
            private set
        lateinit var database:WeatherDatabase
            private set
        lateinit var apiService : WeatherApiService
            private set
        lateinit var sharedPrefs : PreferencesManager
            private set
        lateinit var repository: WeatherRepository
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        //database = WeatherDatabase.getInstance(instance)
        apiService = Retrofit.Builder()
                .baseUrl("https://api.open-meteo.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApiService::class.java)
        sharedPrefs = PreferencesManager(instance)
        repository = WeatherRepository(/*database.weatherDao(),*/ apiService, sharedPrefs)
    }
}
