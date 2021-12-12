package com.information_systems.backend.service.impl

import com.information_systems.backend.client.RecipesRestClient
import com.information_systems.backend.convertors.AbstractConvertor
import com.information_systems.backend.dto.response.RecipeFullResponse
import com.information_systems.backend.dto.response.RecipeShortResponse
import com.information_systems.backend.model.response.RecipeFullView
import com.information_systems.backend.model.response.RecipeShortView
import com.information_systems.backend.service.RecipeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class RecipeServiceImpl : RecipeService {

    @Autowired
    private lateinit var recipesClient: RecipesRestClient

    @Autowired
    private lateinit var recipeFullConvertor: AbstractConvertor<RecipeFullResponse, RecipeFullView>

    @Autowired
    private lateinit var recipeShortConvertor: AbstractConvertor<RecipeShortResponse, RecipeShortView>

    private val defaultNumber = 10
    private val defaultOffset = 0

    override fun getAll(number: Int?, offset: Int?): RecipeShortView {
        return recipeShortConvertor.convert(recipesClient.getAll(number?:defaultNumber, offset?:defaultOffset))
    }

    @Cacheable(value = ["recipes"], key = "#id")
    override fun getById(id: String): RecipeFullView {
        return recipeFullConvertor.convert(recipesClient.getById(id))
    }

    override fun getByIngredients(ingredients: List<String>, number: Int?): RecipeShortView {
        return recipeShortConvertor.convert(recipesClient.getByIngredients(ingredients, number?:defaultNumber))
    }

    @Cacheable(value = ["short_recipes"], key = "#id")
    override fun getSame(id: String, number: Int?): RecipeShortView {
        return recipeShortConvertor.convert(recipesClient.getSameById(id, number?:defaultNumber))
    }
}