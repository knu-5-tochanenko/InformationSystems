package com.information_systems.backend.dto.response

import com.information_systems.backend.dto.IngredientsDto
import lombok.Data

@Data
data class RecipeFullResponse(
        val id: Long,
        val title: String,
        val readyInMinutes: Long,
        val servings: Int,
        val image: String,
        val summary: String,
        val instructions: String,
        val shortUrl: String,
        val extendedIngredients: IngredientsDto
)