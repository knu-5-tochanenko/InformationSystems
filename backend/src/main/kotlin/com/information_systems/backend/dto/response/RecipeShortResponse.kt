package com.information_systems.backend.dto.response

import com.information_systems.backend.dto.RecipeShortDto
import lombok.Data

@Data
data class RecipeShortResponse (
    val results: List<RecipeShortDto>
)