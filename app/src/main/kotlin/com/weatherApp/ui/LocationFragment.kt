package com.weatherApp.ui

import android.os.Bundle
import com.weatherApp.R
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.weatherApp.ApplicationContext

class LocationFragment : Fragment(R.layout.fragment_location){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val repository = ApplicationContext.repository
        val cityEdit = view.findViewById<EditText>(R.id.editCity)
        val latEdit = view.findViewById<EditText>(R.id.editLatitude)
        val lonEdit = view.findViewById<EditText>(R.id.editLongitude)
        val saveBtn = view.findViewById<Button>(R.id.btnSave)

        if(repository.getSavedLocation().first == null) {
            updateCurrentDataTextView(view,String.format("No data saved. Save a new city!"))
        }else{
            updateCurrentDataTextView(view,String.format("Current data: city name: %s, latitude: %f, longitude: %f",
                repository.getSavedLocation().first,repository.getSavedLocation().second,repository.getSavedLocation().third))
        }

        saveBtn.setOnClickListener {
            val city = cityEdit.text.toString()
            val lat = latEdit.text.toString()
            val lon = lonEdit.text.toString()
            if (city.isEmpty() || lat.isEmpty() || lon.isEmpty()){
                Toast.makeText(requireContext(), "One of the fields is empty", Toast.LENGTH_SHORT).show()
            }
            else{
                repository.saveLocation(city, lat.toDouble(), lon.toDouble())
                Toast.makeText(requireContext(), "Saved location", Toast.LENGTH_SHORT).show()
                updateCurrentDataTextView(view,String.format("Current data: city name: %s, latitude: %f, longitude: %f",
                    repository.getSavedLocation().first,repository.getSavedLocation().second,repository.getSavedLocation().third))
                cityEdit.text.clear()
                latEdit.text.clear()
                lonEdit.text.clear()
            }
        }
    }

    fun updateCurrentDataTextView(view: View, text:String){
        val currentData = view.findViewById<TextView>(R.id.textCurrent)
        currentData.text = text
    }
}
