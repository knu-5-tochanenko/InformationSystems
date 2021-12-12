package com.information_systems.backend.model

import com.fasterxml.jackson.annotation.JsonInclude
import lombok.Data

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class Recipe (
        val id: String,
        val title: String,
        val image: String?
)