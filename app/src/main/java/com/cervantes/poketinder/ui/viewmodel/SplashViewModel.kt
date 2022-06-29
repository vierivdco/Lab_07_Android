package com.cervantes.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cervantes.poketinder.data.database.FirebaseRemoteConfigRepository

class SplashViewModel: ViewModel() {
    private var firesbaseRemoteConfigRepository = FirebaseRemoteConfigRepository()

    init{
        firesbaseRemoteConfigRepository.init()
    }

    fun getIsUnderMaintenance(): MutableLiveData<Boolean> {
        return firesbaseRemoteConfigRepository.isUnderMaintenanceLiveData
    }

}