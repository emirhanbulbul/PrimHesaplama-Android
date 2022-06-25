package com.dzdtech.primhesaplama.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Bu sınıftan nesne üretmeyeceğimiz için abstrack class yaptık.
abstract class RetrofitInstance {
    companion object {
        private val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.baseUrl)
            .build()

        val retrofitDashboardInstance: DashboardApi by lazy {
            retrofit.create(DashboardApi::class.java)
        }

        val retrofitLoginInstance: LoginApi by lazy{
            retrofit.create(LoginApi::class.java)
        }
    }
}