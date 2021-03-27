package com.willyweather.assignment.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.willyweather.assignment.data.model.TeamsItem

class DataConverter {

    @TypeConverter
    fun fromTeamItems(value: List<TeamsItem>): String {
        val gson = Gson()
        val type = object : TypeToken<List<TeamsItem>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toTeamItems(value: String): List<TeamsItem> {
        val gson = Gson()
        val type = object : TypeToken<List<TeamsItem>>() {}.type
        return gson.fromJson(value, type)
    }
}