package com.dzdtech.primhesaplama.services

import com.dzdtech.primhesaplama.model.CallsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CallsApi {

    @GET("itsms/")
    suspend fun getCallsAllData(
        @Query("userId") userId:String
    ): List<CallsResponse>

    @GET("itsms/")
    suspend fun getCallsClosedData(
        @Query("userId") userId:String, @Query("itsmStatus") status:String
    ): List<CallsResponse>

    @GET("itsms/")
    suspend fun getCallsContinuesData(
        @Query("userId") userId:String, @Query("itsmStatus") status:String
    ): List<CallsResponse>

}