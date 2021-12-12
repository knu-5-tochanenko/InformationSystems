package com.information_systems.backend.client.impl

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class RecipesClientConfig {
    @Value("\${recipe.api.url.getAll}")
    lateinit var GET_ALL_URL: String
    @Value("\${recipe.api.url.getSame}")
    lateinit var GET_SAME_URL: String
    @Value("\${recipe.api.url.getById}")
    lateinit var GET_BY_ID_URL: String
    @Value("\${recipe.api.url.getByIngredients}")
    lateinit var GET_BY_INGREDIENTS_URL: String
}