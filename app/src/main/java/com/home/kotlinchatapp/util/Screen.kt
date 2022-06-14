package com.home.kotlinchatapp.util

const val ROOT_ROUTE: String = "root_route"
const val AUTH_ROUTE: String = "authentication_route"

sealed class Screen(val route: String) {
    object Login: Screen("login_screen")
    object Register: Screen("register_screen")
    object Chat: Screen("chat_screen")
    object ChatGroups: Screen("chat_groups_screen")
    object AccountInfo: Screen("account_info_screen")
}
