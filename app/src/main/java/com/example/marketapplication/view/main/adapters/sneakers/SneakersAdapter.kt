package com.example.marketapplication.view.main.adapters.sneakers


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marketapplication.R
import com.example.marketapplication.domain.model.SneakersItem

class SneakersAdapter : RecyclerView.Adapter<SneakersViewHolder>() {

    private var items = mutableListOf<SneakersItem>()
    var itemClickListener: (() -> (Unit))? = null

    fun setItems(itemsList: List<SneakersItem>) {
        items.addAll(itemsList)
        notifyDataSetChanged()
    }

    fun clearItems() {
        items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SneakersViewHolder {
        return SneakersViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_sneakers, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SneakersViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemClickListener = itemClickListener
    }

    override fun getItemCount(): Int {
        return items.size
    }


}


