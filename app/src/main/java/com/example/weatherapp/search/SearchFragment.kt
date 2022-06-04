package com.example.weatherapp.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.weatherapp.DBHelper
import com.example.weatherapp.WeatherDetailsActivity
import com.example.weatherapp.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private lateinit var searchButton: Button
    private lateinit var historyButton: Button
    private lateinit var searchEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSearchBinding.inflate(inflater)

        binding.lifecycleOwner = this

        searchButton = binding.searchButton
        historyButton = binding.searchHistoryButton
        searchEditText = binding.editTextCity;

        searchButton.setOnClickListener {
            val intent = Intent(activity, WeatherDetailsActivity::class.java);
            val city = searchEditText.text.toString()


            val db = DBHelper(activity?.applicationContext, null);
            db.addSearch(city);

            intent.putExtra("City", city)
            requireActivity().startActivity(intent);
        }

        return binding.root;
    }
}