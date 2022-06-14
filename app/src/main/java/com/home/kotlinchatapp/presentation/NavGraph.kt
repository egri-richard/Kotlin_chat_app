package com.home.kotlinchatapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.home.kotlinchatapp.presentation.account.AccountInfoScreen
import com.home.kotlinchatapp.presentation.authentication.authNavGraph
import com.home.kotlinchatapp.presentation.chat.ChatGroupsScreen
import com.home.kotlinchatapp.presentation.chat.ChatScreen
import com.home.kotlinchatapp.presentation.authentication.login.LoginScreen
import com.home.kotlinchatapp.presentation.authentication.register.RegisterScreen
import com.home.kotlinchatapp.util.ROOT_ROUTE
import com.home.kotlinchatapp.util.Screen

@Composable
fun SetupNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.ChatGroups.route,
        route = ROOT_ROUTE
    ) {
        composable(route = Screen.ChatGroups.route) {
            ChatGroupsScreen()
        }
        composable(route = Screen.Chat.route) {
            ChatScreen()
        }
        composable(route = Screen.AccountInfo.route) {
            AccountInfoScreen()
        }
        authNavGraph(navHostController = navHostController)
    }
}