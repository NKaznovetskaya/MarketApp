package com.example.marketapplication.view.main.adapters.sneakers


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.marketapplication.R
import com.example.marketapplication.domain.model.Sneakers

class SneakersAdapter : ListAdapter<Sneakers, SneakersViewHolder>(SneakersDiffUtil()) {

    private var items = mutableListOf<Sneakers>()
    var itemClickListener: ((Sneakers) -> (Unit))? = null

    fun setItems(itemsList: List<Sneakers>) {
        items.addAll(itemsList)
        notifyDataSetChanged()
    }

    fun getItems(): List<Sneakers> {
        return items
    }

    fun clearItems() {
        items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SneakersViewHolder {
        return SneakersViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_sneakers, parent, false )
        )
    }

    override fun onBindViewHolder(holder: SneakersViewHolder, position: Int) {
        val item = items[holder.adapterPosition]
        holder.bind(item)
        holder.itemClickListener = itemClickListener
    }

    override fun getItemCount(): Int {
        return items.size
    }


}


