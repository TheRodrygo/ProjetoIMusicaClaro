package com.rodrigo.projeto_imusica_claro.presentation.home.screen.configuration

import android.Manifest
import android.app.Activity
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.rodrigo.projeto_imusica_claro.R
import com.rodrigo.projeto_imusica_claro.presentation.base.components.topbar.TopBar
import com.rodrigo.projeto_imusica_claro.presentation.base.theme.ProjetoiMusicaClaroTheme
import com.rodrigo.projeto_imusica_claro.presentation.base.view_model.InactivityViewModel
import com.rodrigo.projeto_imusica_claro.presentation.home.navigation.HomeScreen
import com.rodrigo.projeto_imusica_claro.presentation.home.navigation.HomeScreen.HomeConfiguration
import com.rodrigo.projeto_imusica_claro.presentation.home.screen.configuration.components.CameraView
import com.rodrigo.projeto_imusica_claro.presentation.home.screen.configuration.components.CircleImageWithBorder
import com.rodrigo.projeto_imusica_claro.presentation.home.screen.configuration.components.LanguageDropdownMenu
import java.io.File
import java.util.concurrent.Executors

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun HomeConfigurationScreen(
    activity: Activity,
    navController: NavHostController,
    backPressedDispatcher: OnBackPressedDispatcher,
    viewModel: HomeConfigurationViewModel,
    inactivityViewModel: InactivityViewModel
) {
    val cameraPermission = Manifest.permission.CAMERA
    val context = LocalContext.current
    val permissionState = rememberPermissionState(cameraPermission)
    val pointerModifier = Modifier.pointerInput(Unit) {
        detectTapGestures(onTap = {
            inactivityViewModel.onUserInteraction()
        },
            onPress = {
                inactivityViewModel.onUserInteraction()
            })
        detectDragGestures { change, dragAmount ->
            inactivityViewModel.onUserInteraction()
        }
    }

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted: Boolean ->
            if (isGranted) {
                HomeScreen.HomeConfigurationCam.navigate(
                    navHostController = navController,
                )
            } else {
                Toast.makeText(context, "Não é possível abrir a câmera, permissão negada.", Toast.LENGTH_SHORT).show()
            }
        }
    )

    ProjetoiMusicaClaroTheme {
        Scaffold(
            backgroundColor = MaterialTheme.colors.background,
            topBar = {
                TopBar(
                    title = stringResource(id = R.string.home_configuration_title),
                    hasConfigurationIcon = false,
                    onBackPressed = {
                        backPressedDispatcher.onBackPressed()
                        inactivityViewModel.onUserInteraction()
                    }
                )
            }
        ) { paddingValues ->
            Column(modifier = pointerModifier
                .padding(paddingValues = paddingValues)
                .fillMaxSize()
                ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CircleImageWithBorder(
                        imageUri = getImageUri(context = context),
                        onCameraClick = {
                            inactivityViewModel.onUserInteraction()
                            if (permissionState.hasPermission) {
                                HomeScreen.HomeConfigurationCam.navigate(
                                    navHostController = navController,
                                )
                            } else {
                                requestPermissionLauncher.launch(cameraPermission)
                            }
                        }
                    )
                    LanguageDropdownMenu(
                        activity = activity,
                        viewModel = viewModel,
                        inactivityViewModel = inactivityViewModel
                    )
                }

            }
        }
    }
}

fun getImageUri(context: Context): Uri? {
    val sharedPref = context.getSharedPreferences("MySharedPrefs", Context.MODE_PRIVATE)
    val imageUriString = sharedPref.getString("image_uri", null)
    return if (imageUriString != null) Uri.parse(imageUriString) else null
}