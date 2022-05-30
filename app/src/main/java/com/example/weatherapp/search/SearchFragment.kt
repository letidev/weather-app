package com.example.weatherapp.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var searchButton: Button
    private lateinit var historyButton: Button
    private lateinit var searchEditText: EditText

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSearchBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        searchButton = binding.searchButton
        historyButton = binding.searchHistoryButton
        searchEditText = binding.editTextCity;

        searchButton.setOnClickListener {
            viewModel.getCurrentWeather(searchEditText.text.toString())
        }

        return binding.root;
    }
}