package com.dzdtech.primhesaplama.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dzdtech.primhesaplama.model.CallsResponse
import com.dzdtech.primhesaplama.services.Constants
import com.dzdtech.primhesaplama.services.RetrofitInstanceNewApi
import kotlinx.coroutines.launch

class CallViewModel : ViewModel() {
    val TAG = "Call View Model"
    private var _data = MutableLiveData<List<CallsResponse>>()
    val data: MutableLiveData<List<CallsResponse>>
        get() = _data


    val progress: Boolean = false

    fun getAllData() {
        viewModelScope.launch {
            try {
                _data.value = RetrofitInstanceNewApi.retrofitCallsInstance.getCallsAllData(
                    Constants.idValue
                )
            } catch (e: Exception) {
                Log.e(TAG, "${e.message}")
            }
        }
    }

    fun getClosedData() {
        viewModelScope.launch {
            try {
                _data.value = RetrofitInstanceNewApi.retrofitCallsInstance.getCallsClosedData(
                    Constants.idValue, "1"
                )
            } catch (e: Exception) {
                Log.e(TAG, "${e.message}")
            }
        }
    }

    fun getContinuesData() {
        viewModelScope.launch {
            try {
                _data.value =
                    RetrofitInstanceNewApi.retrofitCallsInstance.getCallsContinuesData(
                        Constants.idValue, "6"
                    )
            } catch (e: Exception) {
                Log.e(TAG, "${e.message}")
            }
        }
    }

}