package com.tochanenko.recipefinder

data class Recipe (
    val id: Int,
    val imageUrl: String,
    val title: String,
    val favorite: Boolean = false
)
