package com.example.marketapplication.domain.model


data class SneakersItem(
    val imageUrl: String,
    val name: String,
    val price: String,
    val nameMaterial: String,
    val size: String,
    val long: String,
    val width: String,
    val isFavorite: Boolean = false,
    val isSold: Boolean = false
)