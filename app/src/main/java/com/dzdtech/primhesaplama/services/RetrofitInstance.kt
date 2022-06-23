package com.dzdtech.primhesaplama.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Bu sınıftan nesne üretmeyeceğimiz için abstrack class yaptık.
abstract class RetrofitInstance {
    companion object {
        private val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://62b2469220cad3685c8c1095.mockapi.io/")
            .build()

        val retrofitDashboardInstance: DashboardApi by lazy {
            retrofit.create(DashboardApi::class.java)
        }
    }
}