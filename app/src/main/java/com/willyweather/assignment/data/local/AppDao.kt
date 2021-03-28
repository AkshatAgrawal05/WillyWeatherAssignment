package com.willyweather.assignment.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.willyweather.assignment.data.model.Teams
import com.willyweather.assignment.data.model.TeamsItem

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTeams(teams: Teams)

    @Query("SELECT * FROM teams")
    fun getAllTeams(): LiveData<Teams>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeamDetails(teamsItem: TeamsItem)

    @Query("SELECT * FROM team_details WHERE id = :id")
    fun getTeamDetailsById(id: Int): LiveData<TeamsItem>
}