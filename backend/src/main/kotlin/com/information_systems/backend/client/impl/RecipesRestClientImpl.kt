package com.information_systems.backend.client.impl

import com.information_systems.backend.client.RecipesRestClient
import com.information_systems.backend.dto.RecipeShortDto
import com.information_systems.backend.dto.response.RecipeFullResponse
import com.information_systems.backend.dto.response.RecipeShortResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.server.ResponseStatusException


@Service
class RecipesRestClientImpl : RecipesRestClient {
    val restTemplate = RestTemplate()

    @Autowired
    lateinit var recipesConfig: RecipesClientConfig

    override fun getAll(number: Int, offset: Int): RecipeShortResponse {
        try {
            return restTemplate.getForObject(recipesConfig.GET_ALL_URL.format(number, offset), RecipeShortResponse::class.java)
                    ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Recipes are not found")
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Error while processing recipe request")
        }
    }

    override fun getById(id: String): RecipeFullResponse {
        try {
            return restTemplate.getForObject(recipesConfig.GET_BY_ID_URL.format(id), RecipeFullResponse::class.java)
                    ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Recipes are not found")
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Error while processing recipe request")
        }
    }

    override fun getByIngredients(ingredients: List<String>, number: Int): RecipeShortResponse {
        try {
            val recipeShortDto = restTemplate.getForObject(recipesConfig.GET_BY_INGREDIENTS_URL.format(ingredients.joinToString(), number), Array<RecipeShortDto>::class.java)
                    ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Recipes are not found")
            return RecipeShortResponse(recipeShortDto.toList(), null)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Error while processing recipe request")
        }
    }

    override fun getSameById(id: String, number: Int): RecipeShortResponse {
        try {
            val recipeShortDto = restTemplate.getForObject(recipesConfig.GET_SAME_URL.format(id, number), Array<RecipeShortDto>::class.java)
                    ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Recipes are not found")
            return RecipeShortResponse(recipeShortDto.toList(), null)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Error while processing recipe request")
        }
    }
}