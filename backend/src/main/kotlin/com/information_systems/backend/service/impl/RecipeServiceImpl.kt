package com.information_systems.backend.service.impl

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class RecipeServiceImpl {
    fun getAll() {

    }

    @Cacheable(value = ["recipes"], key = "#id")
    fun getById(id: String) {

    }

    fun getByIngredients() {

    }

    @Cacheable(value = ["short_recipes"], key = "#id")
    fun getSame(id: String) {

    }

    fun getPopular() {

    }
}