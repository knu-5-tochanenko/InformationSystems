package com.information_systems.backend.convertors.impl

import com.information_systems.backend.convertors.AbstractConvertor
import com.information_systems.backend.dto.RecipeShortDto
import com.information_systems.backend.dto.response.RecipeShortResponse
import com.information_systems.backend.model.Recipe
import com.information_systems.backend.model.response.RecipeShortView
import org.springframework.stereotype.Component

@Component
class RecipesShortViewConvertor : AbstractConvertor<RecipeShortResponse, RecipeShortView> {
    override fun convert(from: RecipeShortResponse): RecipeShortView {
        return RecipeShortView(
                recipes = convertRecipes(from.results),
                totalResults = from.totalResults
        )
    }

    private fun convertRecipes(recipesDto: List<RecipeShortDto>): List<Recipe> {
        return recipesDto.map { recipeDto ->
            Recipe(
                    id = recipeDto.id.toString(),
                    title = recipeDto.title,
                    image = recipeDto.image
            )
        }
    }

}