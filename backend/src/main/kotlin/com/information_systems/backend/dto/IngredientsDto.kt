package com.information_systems.backend.dto

import lombok.Data

@Data
data class IngredientsDto(
        val id: Long,
        val name: String,
        val amount: Float,
        val unit: String
)
