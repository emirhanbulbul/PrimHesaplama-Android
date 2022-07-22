package com.dzdtech.primhesaplama.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RetrofitInstanceNewApi {
    companion object {

        private val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.baseUrlYeni)
            .build()

        val retrofitDashboardInstance: DashboardApi by lazy {
            retrofit.create(DashboardApi::class.java)
        }

        val retrofitCallsInstance: CallsApi by lazy {
            retrofit.create(CallsApi::class.java)
        }


        val retrofitProjectsInstance: ProjectsApi by lazy {
            retrofit.create(ProjectsApi::class.java)
        }





    }
}