package com.willyweather.assignment.data.repository

import com.willyweather.assignment.data.local.AppDao
import com.willyweather.assignment.data.remote.RemoteDataSource
import com.willyweather.assignment.utils.performGetOperation
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: AppDao
) {
    fun getTeamsList(compId: Int) = performGetOperation(
        databaseQuery = { localDataSource.getAllTeams() },
        networkCall = { remoteDataSource.getTeamsList(compId) },
        saveCallResult = { localDataSource.insertAllTeams(it) }
    )

    fun getTeamDetails(teamId: Int) = performGetOperation(
        databaseQuery = { localDataSource.getTeamDetailsById(teamId) },
        networkCall = { remoteDataSource.getTeamDetailsById(teamId) },
        saveCallResult = { localDataSource.insertTeamDetails(it) }
    )
}