package com.example.marketapplication.domain.model

data class Sneakers(
    val ownerId: String,
    val name: String,
    val size: Long,
    val sizeType: String,
    val material: String,
    val length: Long,
    val width: Long,
    val description: String,
    val price: Long
) {
    var isFavorite: Boolean = false
}
