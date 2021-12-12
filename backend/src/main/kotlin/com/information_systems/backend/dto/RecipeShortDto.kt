package com.information_systems.backend.dto

import lombok.Data

@Data
data class RecipeShortDto(
        val id: Long,
        val title: String,
        val image: String?
)