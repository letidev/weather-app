package com.example.weatherapp

import android.widget.Button
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.history.HistoryListAdapter
import com.example.weatherapp.history.SearchHistoryViewModel
import com.example.weatherapp.history.SearchItem
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

@BindingAdapter("weatherListData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<WeatherListItem>?) {
    val adapter = recyclerView.adapter as WeatherListAdapter
    adapter.submitList(data)
}

@BindingAdapter("historyListData")
fun bindHistoryRecyclerView(recyclerView: RecyclerView, data: List<SearchItem>?) {
    val adapter = recyclerView.adapter as HistoryListAdapter
    adapter.submitList(data)
}

@BindingAdapter("listItemId", "itemModel")
fun bindHistoryRecyclerView(button: Button, data: Int?, viewModel: SearchHistoryViewModel?) {
    button.setOnClickListener {
        val db = DBHelper(button.context)
        db.deleteSearch(data)
        viewModel?.getSearches(button.context)
    }
}