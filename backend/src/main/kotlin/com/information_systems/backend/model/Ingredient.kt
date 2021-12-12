package com.information_systems.backend.model

import com.fasterxml.jackson.annotation.JsonInclude
import lombok.Data

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Ingredient (
    val id: String,
    val name: String,
    val amount: Float,
    val unit: String
)