package com.willyweather.assignment.data.remote

import com.willyweather.assignment.data.model.Teams
import com.willyweather.assignment.data.model.TeamsItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiService {
    companion object {
        const val BASE_URL = "https://api.football-data.org/";
    }

    @GET("v2/competitions/{compId}/teams")
    suspend fun getTeamsList(
        @Path("compId") comId: Int,
        @Header("X-Auth-Token") token: String = "4c9d925f79fc41d2945bcc74e93f9e98"
    ): Response<Teams>

    @GET("v2/teams/{teamId}")
    suspend fun getTeamsDetails(
        @Path("teamId") teamId: Int,
        @Header("X-Auth-Token") token: String = "4c9d925f79fc41d2945bcc74e93f9e98"
    ): Response<TeamsItem>
}