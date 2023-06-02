package com.rodrigo.projeto_imusica_claro.presentation.base.utils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appLocaleManager = AppLocaleManager(this)
        appLocaleManager.setLocale(this)
    }
}