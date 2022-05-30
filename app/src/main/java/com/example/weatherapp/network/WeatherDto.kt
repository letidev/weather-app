package com.example.weatherapp.network

import com.squareup.moshi.Json
import java.math.BigDecimal

data class MainWeather(
    val temp: BigDecimal,

    @Json(name = "temp_min")
    val minTemp: BigDecimal,

    @Json(name = "temp_max")
    val maxTemp: BigDecimal
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