package com.example.marketapplication.view.main.adapters.sneakers

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marketapplication.R
import com.example.marketapplication.domain.model.Sneakers

class SneakersViewHolder(view: View): RecyclerView.ViewHolder(view) {

    var itemClickListener: (() -> (Unit))? = null

    val imgSneakers: ImageView = view.findViewById(R.id.imgSneakers)
    val imgLike: ImageView = view.findViewById(R.id.imgLike)
    val tvNameSneakers: TextView = view.findViewById(R.id.tvNameSneakers)
    val tvPrice: TextView = view.findViewById(R.id.tvPrice)
    val tvNameMaterial: TextView = view.findViewById(R.id.tvNameMaterial)
    val tvSize: TextView = view.findViewById(R.id.tvSize)
    val tvSizeType: TextView = view.findViewById(R.id.tvSizeType)
    val tvLength: TextView = view.findViewById(R.id.tvLength)
    val tvWidth: TextView = view.findViewById(R.id.tvWidth)

    fun bind(sneakersItem: Sneakers) {
        tvNameSneakers.text = sneakersItem.name
        tvPrice.text = sneakersItem.price.toString()
        tvNameMaterial.text = sneakersItem.material
        tvSize.text = sneakersItem.size.toString()
        tvSizeType.text = sneakersItem.sizeType
        tvLength.text = sneakersItem.length.toString()
        tvWidth.text = sneakersItem.width.toString()

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