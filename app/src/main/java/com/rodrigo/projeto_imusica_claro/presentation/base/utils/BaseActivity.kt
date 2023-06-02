package com.rodrigo.projeto_imusica_claro.presentation.base.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rodrigo.projeto_imusica_claro.R
import com.rodrigo.projeto_imusica_claro.presentation.base.view_model.InactivityViewModel
import com.rodrigo.projeto_imusica_claro.presentation.home.HomeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

open class BaseActivity : AppCompatActivity() {

    private val inactivityViewModel: InactivityViewModel by viewModel()
    private val notificationManager = NotificationManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appLocaleManager = AppLocaleManager(this)
        appLocaleManager.setLocale(this)

        inactivityViewModel.isInactive.observe(this, { isInactive ->
            if (isInactive) {
                sendInactivityNotification()
            }
        })
    }

    private fun sendInactivityNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(this, NotificationManager.IMPORTANCE_DEFAULT, false,
                "Your Channel Name", "Your Channel Description")
        }

        val intent = Intent(this, HomeActivity::class.java)
        notificationManager.sendNotification(
            CHANNEL_ID,
            getString(R.string.notification_title),
            getString(R.string.notification_description),
            getString(R.string.notification_content),
            R.drawable.splash_screen,
            null,
            R.color.secondary,
            intent
        )
    }

    private fun createNotificationChannel(context: Context, importance: Int, showBadge: Boolean, name: String, description: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(BaseActivity.CHANNEL_ID, name, importance)
            channel.description = description
            channel.setShowBadge(showBadge)

            val notificationManager = context.getSystemService(android.app.NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    companion object {
        const val CHANNEL_ID = "InactivityChannel"
    }
}