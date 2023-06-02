package com.rodrigo.projeto_imusica_claro.presentation.base.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import java.util.*

class AppLocaleManager(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences("AppLocalePrefs", Context.MODE_PRIVATE)

    var language: String
        get() = prefs.getString("language", Locale.getDefault().language) ?: Locale.getDefault().language
        set(value) {
            prefs.edit().putString("language", value).apply()
        }

    var languageName: String
        get() = prefs.getString("languageName", getLanguageName(Locale.getDefault().language)) ?: getLanguageName(Locale.getDefault().language)
        set(value) {
            prefs.edit().putString("languageName", value).apply()
        }

    private fun getLanguageName(languageCode: String): String {
        return when (languageCode) {
            "pt" -> "Português"
            "en" -> "English"
            else -> "Unknown Language"
        }
    }

    fun setLocale(activity: Activity) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        activity.resources.updateConfiguration(config, activity.resources.displayMetrics)
    }
}