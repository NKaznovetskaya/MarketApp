package com.example.marketapplication.utils


import com.example.marketapplication.domain.model.SneakersItem

object ObjectsGeneratorUtils {

    fun sneakersList(favorite: Boolean = false): List<SneakersItem> = listOf(
        SneakersItem("", "Nike", "150",
        "Шкіра", "38", "29", "12", favorite),

        SneakersItem("", "Adidas", "150",
            "Шкіра", "38", "29", "12", favorite),

        SneakersItem("", "NewBalance", "150",
            "Шкіра", "38", "29", "12", favorite)
    )

    fun galleryList(): List<String> = listOf("https://martinvalen.com/13342-large_default/men-s-notch-sole-sneakers-in-full-white.jpg",
        "https://martinvalen.com/13338-large_default/men-s-notch-sole-sneakers-in-full-white.jpg")
}

