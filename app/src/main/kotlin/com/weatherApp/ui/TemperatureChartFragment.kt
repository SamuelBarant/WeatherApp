package com.weatherApp.ui

import com.weatherApp.R
import android.os.Bundle
import android.view.View
import android.graphics.Color
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import java.time.format.DateTimeFormatter
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.weatherApp.ApplicationContext
import com.weatherApp.data.db.WeatherEntity
import java.time.LocalDateTime

class TemperatureChartFragment : Fragment(R.layout.fragment_temperature_chart) {
    private lateinit var chart: LineChart

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chart = view.findViewById(R.id.lineChart)

        val repository = ApplicationContext.repository
        val viewModel = WeatherViewModel(repository)

        viewModel.refreshWeather(viewModel.getLocation().second,viewModel.getLocation().third)
        viewModel.getWeather().observe(viewLifecycleOwner) { list ->
            updateChart(chart, list)
        }
    }

    private fun updateChart(chart: LineChart, data: List<WeatherEntity>) {
        if (data.isEmpty()) {
            chart.clear()
            chart.invalidate()
            return
        }

        val entries = ArrayList<Entry>(data.size)
        val labels = ArrayList<String>(data.size)

        data.forEachIndexed { index, entity ->
            entries.add(Entry(index.toFloat(), entity.temperature.toFloat()))

            val label = try {
                val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
                val dateTime = LocalDateTime.parse(entity.time, inputFormatter)
                dateTime.format(DateTimeFormatter.ofPattern("HH:mm"))
            } catch (e: Exception) {
                entity.time
            }
            labels.add(label)
        }

        val set = LineDataSet(entries, "Temperature (°C)").apply {
            mode = LineDataSet.Mode.LINEAR
            setDrawValues(false)
            setDrawCircles(true)
            circleRadius = 3f
            lineWidth = 2f
            color = Color.BLUE
            setCircleColor(Color.BLUE)
        }

        val lineData = LineData(set)
        chart.data = lineData

        chart.xAxis.apply {
            valueFormatter = IndexAxisValueFormatter(labels)
            position = XAxis.XAxisPosition.BOTTOM
            labelRotationAngle = -45f
            setLabelCount(labels.size.coerceAtMost(24), true)
            granularity = 1f
            isGranularityEnabled = true
        }
        chart.axisRight.isEnabled = false
        chart.axisLeft.apply {
            axisMinimum = (data.minOfOrNull { it.temperature }?.toFloat() ?: 0f) - 1f
            axisMaximum = (data.maxOfOrNull { it.temperature }?.toFloat() ?: 0f) + 1f
        }

        chart.description.isEnabled = false
        chart.legend.isEnabled = false

        chart.invalidate()
    }
}
