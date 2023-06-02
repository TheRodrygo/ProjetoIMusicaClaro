package com.rodrigo.projeto_imusica_claro.presentation.splash_screen

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rodrigo.projeto_imusica_claro.R
import com.rodrigo.projeto_imusica_claro.presentation.base.utils.BaseActivity
import com.rodrigo.projeto_imusica_claro.presentation.home.HomeActivity
import com.rodrigo.projeto_imusica_claro.presentation.splash_screen.components.RotatingImage

class SplashScreenActivity : BaseActivity() {
    private val splashTimeout = 5000L
    private val notificationManager =
        com.rodrigo.projeto_imusica_claro.presentation.base.utils.NotificationManager(this) // Instantiate your NotificationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(this, NotificationManager.IMPORTANCE_DEFAULT, false,
                "Your Channel Name", "Your Channel Description")
        }

        // Send a notification
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

        setContent {
            MySplashScreen()
        }
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(intent)
            finish()
        }, splashTimeout)
    }

    private fun createNotificationChannel(context: Context, importance: Int, showBadge: Boolean, name: String, description: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = description
            channel.setShowBadge(showBadge)

            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    companion object {
        const val CHANNEL_ID = "InactivityChannel"
    }
}

@Composable
fun MySplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        RotatingImage(
            imageResId = R.drawable.splash_screen,
            imageSize = 200.dp
        )
    }
}
