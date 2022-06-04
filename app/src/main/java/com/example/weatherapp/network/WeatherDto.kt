package com.example.weatherapp.network

import com.squareup.moshi.Json
import java.io.Serializable
import java.math.BigDecimal

data class MainWeather(
    val temp: Double,

    @Json(name = "temp_min")
    val minTemp: Double,

    @Json(name = "temp_max")
    val maxTemp: Double
)

data class WeatherConditionName (
    val main: String,
    val description: String,
    val icon: String
        )

data class WeatherListItem (
    val dt: Int,

    @Json(name = "dt_txt")
    val dtFormatted: String,

    val main: MainWeather,

    val weather: List<WeatherConditionName>
        )

data class WeatherDto (
    val cod: String,
    val list: List<WeatherListItem>
)