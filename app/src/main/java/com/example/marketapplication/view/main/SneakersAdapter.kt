package com.example.marketapplication.view.main


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marketapplication.R
import com.example.marketapplication.domain.model.SneakersItem

 class SneakersAdapter : RecyclerView.Adapter<SneakersAdapter.SneakersViewHolder>() {

    private var items = mutableListOf<SneakersItem>()

    fun setItems(itemsList: List<SneakersItem>) {
        items.addAll(itemsList)
        notifyDataSetChanged()
    }
    fun clearItems() {
        items.clear()
        notifyDataSetChanged()
    }

    inner class SneakersViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imgSneakers: ImageView = view.findViewById(R.id.imgSneakers)
        val tvNameSneakers: TextView = view.findViewById(R.id.tvNameSneakers)
        val tvPrice: TextView = view.findViewById(R.id.tvPrice)
        val tvNameMaterial: TextView = view.findViewById(R.id.tvNameMaterial)
        val tvSize: TextView = view.findViewById(R.id.tvSize)
        val tvLong: TextView = view.findViewById(R.id.tvLong)
        val tvWidth: TextView = view.findViewById(R.id.tvWidth)

        fun bind(item: SneakersItem) {
            tvNameSneakers.text = item.tvNameSneakers
            tvPrice.text = item.tvPrice
            tvNameMaterial.text = item.tvNameMaterial
            tvSize.text = item.tvSize
            tvLong.text = item.tvLong
            tvWidth.text = item.tvWidth


        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SneakersViewHolder {
        return SneakersViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_sneakers, parent, false))

    }

    override fun onBindViewHolder(holder: SneakersViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }


}


