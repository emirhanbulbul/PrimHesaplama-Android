package com.dzdtech.primhesaplama.services

import com.dzdtech.primhesaplama.model.Dashboard
import retrofit2.http.GET
import retrofit2.http.Path

interface DashboardApi {


    @GET("dashboard/{value}")
   suspend fun getDashboardData(@Path("value") value:String) : Dashboard
}