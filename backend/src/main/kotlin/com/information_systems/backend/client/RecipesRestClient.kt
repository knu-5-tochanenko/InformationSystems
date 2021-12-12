package com.information_systems.backend.client

import com.information_systems.backend.dto.response.RecipeFullResponse
import com.information_systems.backend.dto.response.RecipeShortResponse

interface RecipesRestClient {
    fun getAll(number: Int, offset: Int): RecipeShortResponse
    fun getById(id: String): RecipeFullResponse
    fun getByIngredients(ingredients: List<String>, number: Int): RecipeShortResponse
    fun getSameById(id: String, number: Int): RecipeShortResponse
}