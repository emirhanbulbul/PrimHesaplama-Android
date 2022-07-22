package com.dzdtech.primhesaplama.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dzdtech.primhesaplama.model.DashboardResponse
import com.dzdtech.primhesaplama.services.Constants
import com.dzdtech.primhesaplama.services.RetrofitInstanceNewApi
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    val TAG = "Dashboard View Model"
    private var _data = MutableLiveData<List<DashboardResponse>>()
    val data: MutableLiveData<List<DashboardResponse>>
        get() = _data


    val progress: Boolean = false

    fun getData() {
        viewModelScope.launch {
            try {
                _data.value =
                    RetrofitInstanceNewApi.retrofitDashboardInstance.getDashboardData(Constants.idValue)
            } catch (e: Exception) {
                Log.e(TAG, "${e.message}")
            }
        }
    }

}