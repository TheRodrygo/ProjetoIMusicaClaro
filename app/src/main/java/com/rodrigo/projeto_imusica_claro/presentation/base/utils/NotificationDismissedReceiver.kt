package com.rodrigo.projeto_imusica_claro.presentation.base.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.rodrigo.projeto_imusica_claro.presentation.home.HomeActivity

class NotificationDismissedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val activityIntent = Intent(context, HomeActivity::class.java)
        activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(activityIntent)
    }
}