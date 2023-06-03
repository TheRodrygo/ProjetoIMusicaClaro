package com.rodrigo.projeto_imusica_claro.presentation.home.navigation

import com.rodrigo.projeto_imusica_claro.presentation.base.navigation.Screens

sealed class HomeScreen(route: String, argumentKey: String) : Screens(route, argumentKey) {
    object HomeList : HomeScreen(
        route = "home_list",
        argumentKey = "home_list"
    )

    object HomeConfiguration : HomeScreen(
        route = "home_configuration",
        argumentKey = "home_configuration"
    )

    object HomeConfigurationCam : HomeScreen(
        route = "home_configuration_cam",
        argumentKey = "home_configuration_cam"
    )
}