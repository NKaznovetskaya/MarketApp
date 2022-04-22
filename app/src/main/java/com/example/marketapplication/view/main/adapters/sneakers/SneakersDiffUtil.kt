package com.example.marketapplication.view.main.adapters.sneakers

import androidx.recyclerview.widget.DiffUtil
import com.example.marketapplication.domain.model.Sneakers

class SneakersDiffUtil: DiffUtil.ItemCallback<Sneakers>() {

    override fun areItemsTheSame(oldItem: Sneakers, newItem: Sneakers): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Sneakers, newItem: Sneakers): Boolean {
        return oldItem == newItem
    }

}