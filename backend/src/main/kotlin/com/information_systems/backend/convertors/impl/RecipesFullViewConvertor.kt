package com.information_systems.backend.convertors.impl

import com.information_systems.backend.convertors.AbstractConvertor
import com.information_systems.backend.dto.IngredientsDto
import com.information_systems.backend.dto.response.RecipeFullResponse
import com.information_systems.backend.model.Ingredient
import com.information_systems.backend.model.response.RecipeFullView
import org.springframework.stereotype.Component

@Component
class RecipesFullViewConvertor : AbstractConvertor<RecipeFullResponse, RecipeFullView> {
    override fun convert(from: RecipeFullResponse): RecipeFullView {
        return RecipeFullView(
                id = from.id.toString(),
                title = from.title,
                readyInMinutes = from.readyInMinutes,
                servings = from.servings,
                image = from.image,
                summary = from.summary,
                instructions = from.instructions,
                sourceUrl = from.sourceUrl,
                ingredients = convertIngredients(from.extendedIngredients)
        )
    }

    private fun convertIngredients(ingredientsDto: List<IngredientsDto>): List<Ingredient> {
        return ingredientsDto.map { ingredientDto ->
            Ingredient(
                    id = ingredientDto.id.toString(),
                    name = ingredientDto.name,
                    amount = ingredientDto.amount,
                    unit = ingredientDto.unit
            )
        }
    }
}