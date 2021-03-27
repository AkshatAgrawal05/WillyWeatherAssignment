package com.willyweather.assignment.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.willyweather.assignment.data.model.Teams

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTeams(teams: Teams)

    @Query("SELECT * FROM teams")
    fun getAllTeams(): LiveData<Teams>

}