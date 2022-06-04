package com.example.weatherapp.weatherdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.network.WeatherApi
import com.example.weatherapp.network.WeatherDto
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception

class WeatherDetailsViewModel : ViewModel() {
    private val _response = MutableLiveData<WeatherDto>()
    private val _cod = MutableLiveData<String?>();
    private val _units = "metric"
    private val _appid = "78c51d4bee44b9fe91dfc096673678ef"

    val cod: LiveData<String?> = _cod;

    init {
        _cod.value = "Loading..."
    }

    fun getCurrentWeather(city: String) {
        viewModelScope.launch {
            try {
                _response.value = WeatherApi.retrofitService.getCurrentWeather(city, _units, _appid)
                _cod.value = _response.value!!.list.size.toString()
            } catch(e: HttpException) {
                if(e.code() == 404) {
                    _cod.value = "City not found";
                } else {
                    throw Exception(e)
                }
            } catch (e: Exception) {
                _cod.value = e.message
            }
        }
    }
}