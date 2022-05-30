package com.example.weatherapp.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.network.WeatherApi
import com.example.weatherapp.network.WeatherDto
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception

class SearchViewModel : ViewModel() {
    private val _response = MutableLiveData<WeatherDto>()
    private val _text = MutableLiveData<String>()
    private val _units = "metric"
    private val _appid = "78c51d4bee44b9fe91dfc096673678ef"

    val text: LiveData<String> = _text

    init {
        _text.value = "No requests made yet"
    }

    fun getCurrentWeather(city: String) {
        viewModelScope.launch {
            try {
                _response.value = WeatherApi.retrofitService.getCurrentWeather(city, _units, _appid)
                _text.value = _response.value!!.cod
            } catch(e: HttpException) {
                if(e.code() == 404) {
                    _text.value = "City not found";
                } else {
                    throw Exception(e)
                }
            } catch (e: Exception) {
                _text.value = "Something went wrong"
            }
        }
    }
}