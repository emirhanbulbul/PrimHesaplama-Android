package com.dzdtech.primhesaplama.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dzdtech.primhesaplama.model.User
import com.dzdtech.primhesaplama.services.RetrofitInstance

import kotlinx.coroutines.launch

class LoginActivityViewModel:ViewModel() {

    val TAG = "Login View Model"
    var response: Int = -1
    val progress:Boolean = false
    private val _loginResponse = MutableLiveData<Int>()
    val loginResponse: LiveData<Int>
        get() = _loginResponse

    fun postRequest(email: String, password: String){
        val a = User(email,password)
        viewModelScope.launch {
            try {
              //Post request sonucu olarak kullanıcının id değeri response değişkenine atanır.
              response =  RetrofitInstance.retrofitLoginInstance.postUser(a).id
              _loginResponse.value =  response
            } catch (e: Exception) {
                Log.e(TAG, "${e.message}")
            }

        }


    }
}