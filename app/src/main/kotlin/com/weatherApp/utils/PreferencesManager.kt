package com.weatherApp.utils

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {

    //TODO get sharedPreferences file

    //TODO save data in SharedPreferences
    fun saveLocation(city: String, latitude: Double, longitude: Double) {}
    //TODO implement getters for SharedPreferences values, using mock data by now
    fun getCityName(): String? = "Ávila"
    fun getLatitude(): Float? = 40.6572f
    fun getLongitude(): Float? = -4.6995f
}
