package com.jersson.diaz.losandes.navigation

sealed class NavigationScreen(val screen: String) {
    data object LoginScreen: NavigationScreen("login_screen")
    data object AccountScreen: NavigationScreen("account_screen")
    data object DetailScreen: NavigationScreen("detail_screen")
}