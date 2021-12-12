package com.information_systems.backend.dto

import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Data
@Builder
data class RecipeShortDto(
        val id: Long,
        val title: String,
        val image: String
)