package com.information_systems.backend.service

interface RecipeService {
    fun getAll()
    fun getById(id: String)
    fun getByIngredients()
    fun getSame(id: String)
}