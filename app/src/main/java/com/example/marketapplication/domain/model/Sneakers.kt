package com.example.marketapplication.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sneakers(
    val ownerId: String,
    val name: String,
    val size: Long,
    val sizeType: String,
    val material: String,
    val length: Long,
    val width: Long,
    val description: String,
    val price: Long,
    val isArchive: Boolean = false
): Parcelable {
    var isFavorite: Boolean = false
}
