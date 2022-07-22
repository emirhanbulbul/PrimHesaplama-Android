package com.dzdtech.primhesaplama.services

import com.dzdtech.primhesaplama.model.DashboardResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DashboardApi {

    @GET("totalProgressPayments/")
    suspend fun getDashboardData(
        @Query("userId") userId:String
    ): List<DashboardResponse>

}