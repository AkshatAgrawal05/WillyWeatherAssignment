package com.willyweather.assignment.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.willyweather.assignment.utils.DataConverter

@Entity(tableName = "teams")
data class Teams(
    @PrimaryKey(autoGenerate = true)
    var compId: Int,
    @TypeConverters(DataConverter::class)
    val teams: List<TeamsItem>? = null,
    val count: Int? = null,
    @Embedded(prefix = "season_")
    val season: Season? = null,
    @Embedded(prefix = "comp_")
    val competition: Competition? = null,
    @Embedded(prefix = "filter")
    val filters: Filters? = null
)
