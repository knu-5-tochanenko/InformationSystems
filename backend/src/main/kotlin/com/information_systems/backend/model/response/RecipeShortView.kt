package com.information_systems.backend.model.response

import com.fasterxml.jackson.annotation.JsonInclude
import com.information_systems.backend.model.Recipe
import lombok.Data

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class RecipeShortView (
        val recipes: List<Recipe>,
        val totalResults: Long?
)