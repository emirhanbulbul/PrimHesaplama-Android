package com.dzdtech.primhesaplama.services

import com.dzdtech.primhesaplama.model.Dashboard
import retrofit2.http.GET

interface DashboardApi {



    @GET("dashboard/1")
    suspend fun getDashboardData() : Dashboard
}