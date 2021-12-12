package com.tochanenko.recipefinder

data class RecipeDTO (
    val id: Int,
    val title: String,
    val readyInMinutes: Int,
    val servings: Int,
    val image: String,
    val summary: String,
    val instructions: String,
    val sourceUrl: String,
    val ingredients: MutableList<IngredientDTO>
)
