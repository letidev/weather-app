package com.example.weatherapp.weatherdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.network.WeatherApi
import com.example.weatherapp.network.WeatherCity
import com.example.weatherapp.network.WeatherListItem
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception

private const val units = "metric";
private const val appid = "78c51d4bee44b9fe91dfc096673678ef"
enum class WeatherApiStatus { LOADING, ERROR, DONE, NOT_FOUND }

class WeatherDetailsViewModel : ViewModel() {
    private val _resultLabel = MutableLiveData<String>();
    private val _list = MutableLiveData<List<WeatherListItem>>();
    private val _status = MutableLiveData<WeatherApiStatus>()

    val resultLabel: LiveData<String> = _resultLabel;
    val list: LiveData<List<WeatherListItem>> = _list
    val status: LiveData<WeatherApiStatus> = _status

    init {
        _resultLabel.value = "Loading..."
    }

    fun getCurrentWeather(city: String) {
        viewModelScope.launch {
            _status.value = WeatherApiStatus.LOADING
            try {
                val response = WeatherApi.retrofitService.getCurrentWeather(city, units, appid)
                _status.value = WeatherApiStatus.DONE
                _resultLabel.value = "Showing weather for ${response.city.name}, ${response.city.country}";
                _list.value = response.list;
            } catch(e: HttpException) {
                if(e.code() == 404) {
                    _resultLabel.value = "City not found";
                    _status.value = WeatherApiStatus.NOT_FOUND
                } else {
                    throw Exception(e)
                }
            } catch (e: Exception) {
                _status.value = WeatherApiStatus.ERROR
                _resultLabel.value = e.message
            }
        }
    }
}