package com.example.listoflists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listoflists.databinding.ItemCarBinding

class CarAdapter: ListAdapter<Car, CarAdapter.CarViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Car>() {
        override fun areItemsTheSame(oldItem: Car, newItem: Car): Boolean {
            //this methods runs first
             //compares if the objects are the same
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Car, newItem: Car): Boolean {
            return oldItem == newItem //compares if this property of the objects are the same
        }
    }

    class CarViewHolder(private var binding: ItemCarBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(car: Car) {
            binding.car = car
            binding.executePendingBindings()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarAdapter.CarViewHolder {
        return CarViewHolder(ItemCarBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CarAdapter.CarViewHolder, position: Int) {
        val car = getItem(position)
        holder.bind(car)
    }
}
