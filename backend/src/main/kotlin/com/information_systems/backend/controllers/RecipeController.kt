package com.information_systems.backend.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/recipe")
class RecipeController {
    @GetMapping
    fun getAllRecipes(@RequestParam("offset") offset: Number, @RequestParam("number") number: Number) {

    }

    @GetMapping
    fun getRecipeById(@RequestParam("id") id: String) {

    }

    @GetMapping
    fun getRecipesByIngredients() {

    }

    @GetMapping("/similar")
    fun getSimilarRecipes(@RequestParam("id") id: String) {

    }
}