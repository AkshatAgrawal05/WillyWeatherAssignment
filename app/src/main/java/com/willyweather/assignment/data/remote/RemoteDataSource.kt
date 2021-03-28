package com.willyweather.assignment.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) : BaseDataSource() {

    /**
     * get list of all teams of a competition
     * default compId = 2018
     */
    suspend fun getTeamsList(compId: Int = 2018) = getResult {
        apiService.getTeamsList(compId)
    }

    /**
     * get Team details by team Id
     */
    suspend fun getTeamDetailsById(teamId: Int) = getResult {
        apiService.getTeamsDetails(teamId)
    }
}