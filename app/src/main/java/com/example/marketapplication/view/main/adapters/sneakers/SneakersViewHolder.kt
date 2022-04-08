package com.example.marketapplication.view.main.adapters.sneakers

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marketapplication.R
import com.example.marketapplication.domain.model.SneakersItem

class SneakersViewHolder(view: View): RecyclerView.ViewHolder(view) {

    var itemClickListener: (() -> (Unit))? = null

    val imgSneakers: ImageView = view.findViewById(R.id.imgSneakers)
    val imgLike: ImageView = view.findViewById(R.id.imgLike)
    val tvNameSneakers: TextView = view.findViewById(R.id.tvNameSneakers)
    val tvPrice: TextView = view.findViewById(R.id.tvPrice)
    val tvNameMaterial: TextView = view.findViewById(R.id.tvNameMaterial)
    val tvSize: TextView = view.findViewById(R.id.tvSize)
    val tvLong: TextView = view.findViewById(R.id.tvLong)
    val tvWidth: TextView = view.findViewById(R.id.tvWidth)

    fun bind(sneakersItem: SneakersItem) {
        tvNameSneakers.text = sneakersItem.name
        tvPrice.text = sneakersItem.price
        tvNameMaterial.text = sneakersItem.nameMaterial
        tvSize.text = sneakersItem.size
        tvLong.text = sneakersItem.long
        tvWidth.text = sneakersItem.width

        val likeDrawable: Int = if (sneakersItem.isFavorite) {
            R.drawable.ic_favorite_ads_red
        } else {
            R.drawable.ic_favorite_ads_white
        }
        imgLike.setImageResource(likeDrawable)

        itemView.setOnClickListener {
            itemClickListener?.invoke()
        }
    }
}