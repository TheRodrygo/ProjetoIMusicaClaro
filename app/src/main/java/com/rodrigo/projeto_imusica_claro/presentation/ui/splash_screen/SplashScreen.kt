package com.rodrigo.projeto_imusica_claro.presentation.ui.splash_screen

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
import com.rodrigo.projeto_imusica_claro.presentation.ui.splash_screen.components.RotatingImage

class SplashScreen : AppCompatActivity() {
    private val splashTimeout = 3000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = getColor(R.color.red)
        }
        setContent {
            MySplashScreen()
        }
        Handler(Looper.getMainLooper()).postDelayed({
            //Adicionar a ação que vai ser feita após o tempo definido.
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
