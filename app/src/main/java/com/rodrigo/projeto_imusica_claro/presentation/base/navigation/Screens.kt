package com.rodrigo.projeto_imusica_claro.presentation.base.navigation

import androidx.navigation.NavHostController

open class Screens(val route: String, val argumentKey: String) {

    fun <T> passArgument(argument: T?): String {
        return this.route.replace(oldValue = "{$argumentKey}", newValue = argument.toString())
    }

    fun backToScreen(navHostController: NavHostController, update: Boolean = true) {
        navHostController.navigate(
            route = passArgument(update)
        ) {
            popUpTo(0)
        }
    }

    fun navigate(navHostController: NavHostController) {
        navHostController.navigate(route)
    }

    fun <T> navigateWithParcelableArgument(
        navHostController: NavHostController,
        argumentValue: T?
    ) {
        navHostController.currentBackStackEntry?.savedStateHandle?.set(
            key = argumentKey,
            value = argumentValue
        )
        navigate(navHostController)
    }

    fun <T> navigateWithParcelableListArgument(
        navHostController: NavHostController,
        argumentValue: List<T>?
    ) {
        navHostController.currentBackStackEntry?.savedStateHandle?.set(
            key = argumentKey,
            value = argumentValue
        )
        navigate(navHostController)
    }
}