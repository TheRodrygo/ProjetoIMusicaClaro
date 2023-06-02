package com.rodrigo.projeto_imusica_claro.presentation.home.screen.configuration.components

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Handler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rodrigo.projeto_imusica_claro.R
import com.rodrigo.projeto_imusica_claro.presentation.base.utils.AppLocaleManager
import com.rodrigo.projeto_imusica_claro.presentation.home.screen.configuration.HomeConfigurationViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LanguageDropdownMenu(
    activity: Activity,
    viewModel: HomeConfigurationViewModel,
) {
    val appLocaleManager = AppLocaleManager(LocalContext.current)
    val expanded = remember { mutableStateOf(false) }

    val selectedLanguageName = remember { mutableStateOf(appLocaleManager.languageName) }

    val languageOptions = remember {
        val languageNames = activity.resources.getStringArray(R.array.language_names)
        val languageCodes = activity.resources.getStringArray(R.array.language_codes)
        languageNames.zip(languageCodes) { name, code -> Pair(name, code) }
    }

    Card(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            modifier = Modifier
                .clickable(onClick = { expanded.value = true }),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = selectedLanguageName.value,
                style = MaterialTheme.typography.body1
            )
            Icon(
                modifier = Modifier.padding(16.dp),
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = stringResource(R.string.home_configuration_title)
            )
        }
    }

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false }
        ) {
            languageOptions.forEach { (languageName, languageCode) ->
                DropdownMenuItem(
                    onClick = {
                        viewModel.setLanguage(languageCode)
                        expanded.value = false

                        appLocaleManager.language = languageCode
                        appLocaleManager.setLocale(activity)

                        CoroutineScope(Dispatchers.Main).launch {
                            delay(150)
                            activity.recreate()
                        }

                        selectedLanguageName.value = languageName
                    }
                ) {
                    Text(languageName)
                }
            }
        }
    }
}