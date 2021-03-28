package com.willyweather.assignment.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team_details")
data class TeamsItem(
	@Embedded(prefix = "area_")
	val area: Area? = null,
	val venue: String? = null,
	val website: String? = null,
	val address: String? = null,
	val crestUrl: String? = null,
	val tla: String? = null,
	val founded: Int? = null,
	val lastUpdated: String? = null,
	val clubColors: String? = null,
	val phone: String? = null,
	val name: String? = null,
	@PrimaryKey
	val id: Int? = null,
	val shortName: String? = null,
	val email: String? = null
)
