package com.example.marketapplication.view.main.adapters.gallery

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marketapplication.R

class GalleryViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val imgGallery: ImageView = view.findViewById(R.id.imgGallery)

    fun bind(urlString: String) {
        Glide.with(itemView.context)
            .load(urlString)
            .into(imgGallery)
    }

}
