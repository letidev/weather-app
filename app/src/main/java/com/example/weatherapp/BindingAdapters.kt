package com.example.weatherapp

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.network.WeatherListItem
import com.example.weatherapp.weatherdetail.WeatherListAdapter

@BindingAdapter("dataTemp")
fun bindTemperature(textView: TextView, dataTemp: Double?) {
    textView.text = "Temperature: ${dataTemp.toString()}";
}

@BindingAdapter("dataMinTemp")
fun bindMinTemperature(textView: TextView, dataTemp: Double?) {
    textView.text = "Min temperature: ${dataTemp.toString()}";
}

@BindingAdapter("dataMaxTemp")
fun bindMaxTemperature(textView: TextView, dataTemp: Double?) {
    textView.text = "Max temperature ${dataTemp.toString()}";
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<WeatherListItem>?) {
    val adapter = recyclerView.adapter as WeatherListAdapter
    adapter.submitList(data)
}