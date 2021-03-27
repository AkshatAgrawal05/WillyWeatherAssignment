package com.willyweather.assignment.data.model

import androidx.room.Embedded

data class Competition(
    @Embedded(prefix = "area_")
    val area: Area? = null,
    val lastUpdated: String? = null,
    val code: String? = null,
    val name: String? = null,
    val id: Int? = null,
    val plan: String? = null
)
