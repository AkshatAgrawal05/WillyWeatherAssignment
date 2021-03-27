package com.willyweather.assignment.data.model

data class Teams(
    val teams: List<TeamsItem?>? = null,
    val count: Int? = null,
    val season: Season? = null,
    val competition: Competition? = null,
    val filters: Filters? = null
)
