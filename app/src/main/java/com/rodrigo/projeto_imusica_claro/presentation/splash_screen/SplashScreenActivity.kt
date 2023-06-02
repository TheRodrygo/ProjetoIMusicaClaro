package com.rodrigo.projeto_imusica_claro.presentation.splash_screen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.compose.setContent
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySplashScreen()
        }
        val intent = Intent(this, HomeActivity::class.java)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(intent)
            finish()
        }, splashTimeout)
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
