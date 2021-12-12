package com.information_systems.backend.client.impl

import org.springframework.beans.factory.annotation.Value

class RecipesRestClientImpl {
    @Value("\${recipe.api.url}")
    lateinit var url: String
    @Value("\${recipe.api.key}")
    lateinit var apiKey: String
}