package com.home.kotlinchatapp.presentation.authentication

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.home.kotlinchatapp.presentation.authentication.login.LoginScreen
import com.home.kotlinchatapp.presentation.authentication.register.RegisterScreen
import com.home.kotlinchatapp.util.AUTH_ROUTE
import com.home.kotlinchatapp.util.Screen

fun NavGraphBuilder.authNavGraph(
    navHostController: NavHostController
) {
    navigation(
        startDestination = Screen.Login.route,
        route = AUTH_ROUTE
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen()
        }
        composable(route = Screen.Register.route) {
            RegisterScreen()
        }
    }
}