package com.rodrigo.projeto_imusica_claro.presentation.base.view_model

import android.app.Application
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class InactivityViewModel(application: Application) : AndroidViewModel(application) {
    private val _isInactive = MutableLiveData<Boolean>()
    val isInactive: LiveData<Boolean> get() = _isInactive

    private val inactivityHandler = Handler(Looper.getMainLooper())
    private val inactivityRunnable = Runnable {
        _isInactive.value = true
    }
    private val inactivityTimeout = 20000L

    init {
        startInactivityTimer()
    }

    fun onUserInteraction() {
        resetInactivityTimer()
    }

    fun startInactivityTimer() {
        inactivityHandler.postDelayed(inactivityRunnable, inactivityTimeout)
    }

    fun resetInactivityTimer() {
        inactivityHandler.removeCallbacks(inactivityRunnable)
        inactivityHandler.postDelayed(inactivityRunnable, inactivityTimeout)
    }

    override fun onCleared() {
        super.onCleared()
        inactivityHandler.removeCallbacks(inactivityRunnable)
    }
}
