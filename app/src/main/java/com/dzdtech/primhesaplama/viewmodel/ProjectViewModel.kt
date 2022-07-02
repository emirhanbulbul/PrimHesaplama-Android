package com.dzdtech.primhesaplama.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dzdtech.primhesaplama.model.ProjectsResponse
import com.dzdtech.primhesaplama.services.Constants
import com.dzdtech.primhesaplama.services.RetrofitInstanceNewApi
import kotlinx.coroutines.launch

class ProjectViewModel : ViewModel() {

    val TAG = "Project View Model"
    private var _data = MutableLiveData<List<ProjectsResponse>>()
    val data: MutableLiveData<List<ProjectsResponse>>
        get() = _data


    val progress: Boolean = false

    fun getAllData() {
        viewModelScope.launch {
            try {
                _data.value = RetrofitInstanceNewApi.retrofitProjectsInstance.getProjectsAllData(
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
                _data.value = RetrofitInstanceNewApi.retrofitProjectsInstance.getProjectsClosedData(
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
                    RetrofitInstanceNewApi.retrofitProjectsInstance.getProjectsContinuesData(
                        Constants.idValue, "6"
                    )
            } catch (e: Exception) {
                Log.e(TAG, "${e.message}")
            }
        }
    }


}