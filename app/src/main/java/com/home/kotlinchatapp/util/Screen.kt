package com.home.kotlinchatapp.util

sealed class Screen(val route: String) {
    object Login: Screen("login_screen")
    object Register: Screen("register_screen")
    object Chat: Screen("chat_screen")
    object ChatGroups: Screen("chat_groups_screen")
    object Account: Screen("account_screen")
}
