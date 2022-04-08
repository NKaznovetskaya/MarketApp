package com.example.marketapplication.view.main.adapters.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marketapplication.R


class GalleryAdapter: RecyclerView.Adapter<GalleryViewHolder>() {

    private var items = mutableListOf<String>()

    fun setItems(itemsList: List<String>) {
        items.addAll(itemsList)
        notifyDataSetChanged()

    }
    fun clearItems(){
        items.clear()
        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)

    }
    override fun getItemCount(): Int {
        return items.size

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_gallery, parent, false)
        )
    }
}