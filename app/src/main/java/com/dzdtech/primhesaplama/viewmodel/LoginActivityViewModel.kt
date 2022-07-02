package com.dzdtech.primhesaplama.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dzdtech.primhesaplama.model.User
import com.dzdtech.primhesaplama.model.UserLoginResponse
import com.dzdtech.primhesaplama.services.RetrofitInstance
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginActivityViewModel : ViewModel() {

    val TAG = "Login View Model"

    private val _response = MutableLiveData<Int>()
    val response: LiveData<Int>
        get() = _response


    private val _loginResponse = MutableLiveData<UserLoginResponse>()
    val loginResponse: LiveData<UserLoginResponse>
        get() = _loginResponse

    private val _name = MutableLiveData<Int>()
    val name: LiveData<Int>
        get() = _name

    fun postRequest(email: String, password: String) {
        val a = User(email, password)
        viewModelScope.launch {
            try {
                //Post request sonucu olarak kullanıcının id değeri response değişkenine atanır.
                _loginResponse.value = RetrofitInstance.retrofitLoginInstance.postUser(a)

            } catch (e: HttpException) {
                if (e.code() == 400) {
                    _response.postValue(1)
                    this.cancel()
                }
            }

        }


    }
}