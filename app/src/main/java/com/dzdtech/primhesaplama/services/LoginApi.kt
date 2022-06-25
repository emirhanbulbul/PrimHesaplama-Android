package com.dzdtech.primhesaplama.services

import com.dzdtech.primhesaplama.model.User
import com.dzdtech.primhesaplama.model.UserLoginResponse
import retrofit2.Call
import retrofit2.http.*

interface LoginApi {
    //User bilgileri post edilir, cevap olarak UserLoginResponse
    // modeline kullanıcı id'si çekilir.

    @POST("login")
    suspend fun postUser(@Body usr: User): UserLoginResponse
}