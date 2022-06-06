package com.example.weatherapp.history

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.DBHelper

class SearchHistoryViewModel : ViewModel() {
    private val _searches = MutableLiveData<List<SearchItem>>()

    val searches: LiveData<List<SearchItem>> = _searches

    init {

    }

    @SuppressLint("Range")
    fun getSearches(context: Context?) {
        val db = DBHelper(context)

        val cursor = db.getSearches()
        val list = ArrayList<SearchItem>()

        while(cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndex(DBHelper.ID_COL))
            val city: String = cursor.getString(cursor.getColumnIndex(DBHelper.CITY_COL))

            list.add(SearchItem(id, city))
        }

        _searches.value = list.toList()
    }
}