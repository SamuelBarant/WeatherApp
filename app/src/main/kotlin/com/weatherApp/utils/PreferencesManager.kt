package com.weatherApp.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson

class PreferencesManager(context: Context) {

    private val sharedPreference = SharedPreference(context)
    //TODO get sharedPreferences file

    //TODO save data in SharedPreferences
    fun saveLocation(city: String, latitude: Double?, longitude: Double?) {
        if (sharedPreference.checkConnection().isSuccess){
            sharedPreference.sharedPrefs.edit{
                putString("City",city)
                putFloat("Latitud",latitude?.toFloat() ?: 0.0f)
                putFloat("Longitude",longitude?.toFloat() ?: 0.0f)
            }
        }
    }
    //TODO implement getters for SharedPreferences values, using mock data by now
    fun getCityName(): String? = sharedPreference.sharedPrefs.getString("City",null)
    fun getLatitude(): Float? = sharedPreference.sharedPrefs.getFloat("Latitud",0.0f)
    fun getLongitude(): Float? = sharedPreference.sharedPrefs.getFloat("Longitude",0.0f)
}
