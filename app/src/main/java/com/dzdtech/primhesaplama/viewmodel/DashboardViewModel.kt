package com.dzdtech.primhesaplama.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dzdtech.primhesaplama.model.Dashboard
import com.dzdtech.primhesaplama.services.RetrofitInstance
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    val TAG = "Dashboard View Model"
    private var _data = MutableLiveData<Dashboard>()
    val data: LiveData<Dashboard>
    get() = _data

    val progress:Boolean = false

    fun getData() {
        viewModelScope.launch {
            try {
                _data.value = RetrofitInstance.retrofitDashboardInstance.getDashboardData()
            } catch (e: Exception) {
                Log.e(TAG, "${e.message}")
            }
        }
    }

}