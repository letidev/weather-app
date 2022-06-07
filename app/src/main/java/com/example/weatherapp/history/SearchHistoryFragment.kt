package com.example.weatherapp.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.adapters.HistoryListAdapter
import com.example.weatherapp.databinding.FragmentSearchHistoryBinding

class SearchHistoryFragment : Fragment() {
    private val viewModel: SearchHistoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSearchHistoryBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.getSearches(activity?.applicationContext)

        binding.searchesList.adapter = HistoryListAdapter()

        return binding.root
    }
}