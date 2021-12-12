package com.information_systems.backend.service

import com.information_systems.backend.model.response.RecipeFullView
import com.information_systems.backend.model.response.RecipeShortView

interface RecipeService {
    fun getAll(number: Int?, offset: Int?): RecipeShortView
    fun getById(id: String): RecipeFullView
    fun getByIngredients(ingredients: List<String>, number: Int?): RecipeShortView
    fun getSame(id: String, number: Int?): RecipeShortView
}