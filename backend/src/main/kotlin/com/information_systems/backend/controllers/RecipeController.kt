package com.information_systems.backend.controllers

import com.information_systems.backend.model.response.RecipeFullView
import com.information_systems.backend.model.response.RecipeShortView
import com.information_systems.backend.service.RecipeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/recipe")
class RecipeController {
    @Autowired
    lateinit var recipeService: RecipeService

    @GetMapping
    fun getAllRecipes(@RequestParam("offset", required = false) offset: Int?, @RequestParam("number", required = false) number: Int?): RecipeShortView {
        return recipeService.getAll(number, offset)
    }

    @GetMapping("/{id}")
    fun getRecipeById(@PathVariable id: String): RecipeFullView {
        return recipeService.getById(id)
    }

    @GetMapping("/ingredients")
    fun getRecipesByIngredients(@RequestParam("ingredients") ingredients: List<String>, @RequestParam("number", required = false) number: Int?): RecipeShortView {
        return recipeService.getByIngredients(ingredients, number)
    }

    @GetMapping("/similar/{id}")
    fun getSimilarRecipes(@PathVariable id: String, @RequestParam("number", required = false) number: Int?): RecipeShortView {
        return recipeService.getSame(id, number)
    }
}