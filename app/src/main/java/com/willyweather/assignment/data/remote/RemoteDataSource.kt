package com.willyweather.assignment.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(val apiService: ApiService) : BaseDataSource() {

    /**
     * get list of all teams of a competition
     * default compId = 2018
     */
    suspend fun getTeamsList(compId: Int = 2018) = getResult {
        apiService.getTeamsList(compId)
    }
}