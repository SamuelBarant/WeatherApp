package com.weatherApp.ui

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.weatherApp.ApplicationContext
import com.weatherApp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnViewChart = findViewById<Button>(R.id.btnViewChart)
        val btnModifyLocation = findViewById<Button>(R.id.btnModifyLocation)

        btnViewChart.setOnClickListener {
            val repository = ApplicationContext.repository
            val viewModel = WeatherViewModel(repository)
            if(viewModel.getLocation().first == null){
                Toast.makeText(this, "Save a location first", Toast.LENGTH_SHORT).show()
            }else {
                supportFragmentManager.commit {
                    replace(R.id.fragmentContainer, TemperatureChartFragment())
                    addToBackStack(null)
                }
            }
        }

        btnModifyLocation.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragmentContainer, LocationFragment())
                addToBackStack(null)
            }
        }
    }
}
