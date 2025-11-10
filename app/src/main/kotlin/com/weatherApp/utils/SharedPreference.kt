package com.weatherApp.utils

import android.content.Context

class SharedPreference (private val context: Context){
    private val prefsKey = "weather_prefs"
    val sharedPrefs = context.getSharedPreferences(prefsKey, Context.MODE_PRIVATE)

    fun checkConnection() :Result<Unit>{
        return Result.success(Unit)
    }
}