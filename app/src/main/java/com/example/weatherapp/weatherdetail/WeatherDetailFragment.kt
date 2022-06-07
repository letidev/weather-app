package com.example.weatherapp.weatherdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.adapters.WeatherListAdapter
import com.example.weatherapp.databinding.FragmentWeatherDetailBinding


class WeatherDetailFragment : Fragment() {
    private val viewModel: WeatherDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentWeatherDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val city = activity?.intent!!.getStringExtra("City").toString()
        viewModel.getCurrentWeather(city);

        binding.weatherList.adapter = WeatherListAdapter()

        return binding.root;
    }
}