package com.information_systems.backend.model.response

import com.fasterxml.jackson.annotation.JsonInclude
import com.information_systems.backend.model.Ingredient
import lombok.Builder
import lombok.Data

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class RecipeFullView(
        val id: String,
        val title: String,
        val readyInMinutes: Long,
        val servings: Int,
        val image: String,
        val summary: String,
        val instructions: String,
        val sourceUrl: String,
        val ingredients: List<Ingredient>
)