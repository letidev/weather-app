package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.weatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var searchButton: Button
    private lateinit var historyButton: Button
    private lateinit var searchEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root);

        searchButton = binding.searchButton
        historyButton = binding.searchHistoryButton
        searchEditText = binding.editTextCity;

        searchButton.setOnClickListener {
            Toast.makeText(applicationContext, searchEditText.text, Toast.LENGTH_LONG).show()
        }
    }
}