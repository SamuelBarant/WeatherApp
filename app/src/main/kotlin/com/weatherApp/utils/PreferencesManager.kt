package com.weatherApp.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson

class PreferencesManager(context: Context) {

    private val sharedPreference = SharedPreference(context)
    //TODO get sharedPreferences file

    //TODO save data in SharedPreferences
    fun saveLocation(city: String, latitude: Double, longitude: Double) {
        if (sharedPreference.checkConnection().isSuccess){
            sharedPreference.sharedPrefs.edit{
                putString("City",city)
                putString("Latitud",latitude.toString())
                putString("Longitude",longitude.toString())
            }
        }
    }
    //TODO implement getters for SharedPreferences values, using mock data by now
    fun getCityName(): String? = "Ávila"
    fun getLatitude(): Float? = 40.6572f
    fun getLongitude(): Float? = -4.6995f
}
