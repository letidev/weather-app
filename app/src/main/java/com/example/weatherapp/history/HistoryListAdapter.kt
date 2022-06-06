package com.example.weatherapp.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.SearchHistoryItemBinding

class HistoryListAdapter : ListAdapter<SearchItem, HistoryListAdapter.SearchItemViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : SearchItemViewHolder {
        return SearchItemViewHolder((SearchHistoryItemBinding.inflate(LayoutInflater.from(parent.context))))
    }

    override fun onBindViewHolder(holder: SearchItemViewHolder, position: Int) {
        val searchItem = getItem(position)
        holder.bind(searchItem)
    }

    class SearchItemViewHolder(private var binding: SearchHistoryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(SearchItem: SearchItem) {
            binding.searchItem = SearchItem
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<SearchItem>() {
        override fun areItemsTheSame(oldItem: SearchItem, newItem: SearchItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SearchItem, newItem: SearchItem): Boolean {
            return oldItem.city == newItem.city
        }
    }
}