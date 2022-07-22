package com.dzdtech.primhesaplama.services

import com.dzdtech.primhesaplama.model.ProjectsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ProjectsApi {

    @GET("projects/")
    suspend fun getProjectsAllData(
        @Query("userId") userId: String
    ): List<ProjectsResponse>

    @GET("projects/")
    suspend fun getProjectsClosedData(
        @Query("userId") userId:String, @Query("projectStatus") status:String
    ): List<ProjectsResponse>

    @GET("projects/")
    suspend fun getProjectsContinuesData(
        @Query("userId") userId:String, @Query("projectStatus") status:String
    ): List<ProjectsResponse>

}