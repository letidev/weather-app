package com.example.weatherapp.weatherdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.weatherapp.network.WeatherListItem
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.WeatherItemViewBinding

class WeatherListAdapter : ListAdapter<WeatherListItem, WeatherListAdapter.WeatherListItemViewHolder>(DiffCallback) {

    // the method needs to return a new WeatherListItemViewHolder, created by inflating the WeatherItemViewBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherListItemViewHolder {
        return WeatherListItemViewHolder(WeatherItemViewBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    // here we call getItem to get the MarsPhoto object associated with the current RecyclerView position
    // and then pass that property to the bind method in the MarsPhotoViewHolder
    override fun onBindViewHolder(holder: WeatherListItemViewHolder, position: Int) {
        val weatherListItem = getItem(position)
        holder.bind(weatherListItem)
    }

    class WeatherListItemViewHolder(private var binding: WeatherItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(WeatherListItem: WeatherListItem) {
            binding.weatherListItem = WeatherListItem
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<WeatherListItem>() {
        // this method is called by DiffUtil to decide whether two objects represent the same item
        override fun areItemsTheSame(oldItem: WeatherListItem, newItem: WeatherListItem): Boolean {
            return oldItem.dt == newItem.dt
        }

        // this method is called by DiffUtil when it wants to check whether tow items have the same data
        override fun areContentsTheSame(oldItem: WeatherListItem, newItem: WeatherListItem): Boolean {
            return oldItem.dt == newItem.dt
        }
    }
}