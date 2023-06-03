package com.rodrigo.projeto_imusica_claro.presentation.home.screen.cam

import android.app.Activity
import android.widget.Toast
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.rodrigo.projeto_imusica_claro.R
import com.rodrigo.projeto_imusica_claro.presentation.base.view_model.InactivityViewModel
import com.rodrigo.projeto_imusica_claro.presentation.home.navigation.HomeScreen
import com.rodrigo.projeto_imusica_claro.presentation.home.screen.configuration.components.CameraView
import java.io.File
import java.util.concurrent.Executor
import java.util.concurrent.Executors

@Composable
fun HomeConfigurationCamScreen(
    backPressedDispatcher: OnBackPressedDispatcher,
    activity: Activity,
    inactivityViewModel: InactivityViewModel,
    navController: NavHostController
    ) {
    val executor = Executors.newSingleThreadExecutor()
    val outputDirectory = activity.getOutputDirectory()

    val isCameraViewActive = remember { mutableStateOf(true) }
    if (isCameraViewActive.value) {
        CameraView(
            outputDirectory = outputDirectory,
            executor = executor,
            onImageCaptured = {},
            onError = {},
            backPressedDispatcher = backPressedDispatcher,
            inactivityViewModel = inactivityViewModel,
            navController = navController,
            activity = activity
        )
    }
}

fun Activity.getOutputDirectory(): File {
    val mediaDir = externalMediaDirs.firstOrNull()?.let {
        File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
    }
    return if (mediaDir != null && mediaDir.exists())
        mediaDir else filesDir
}