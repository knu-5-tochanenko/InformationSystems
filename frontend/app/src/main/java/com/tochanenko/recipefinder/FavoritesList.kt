package com.tochanenko.recipefinder

object FavoritesList {
    private var favoritesList = mutableListOf<Recipe>()

    fun add(recipe: Recipe) {
        this.favoritesList.add(recipe)
    }

    fun add(recipe: RecipeDTO) {
        this.favoritesList.add(Recipe(
            recipe.id,
            recipe.image,
            recipe.title,
            true
        ))
    }

    fun delete(id: Int) {
        this.favoritesList = this.favoritesList.filter{ el: Recipe -> el.id != id}.toMutableList()
    }

    fun contains(id: Int): Boolean {
        return this.favoritesList.any { el: Recipe -> el.id == id }
    }

    fun getList(): List<Recipe> {
        return this.favoritesList.toList()
    }
}