package com.jersson.diaz.losandes.navigation

sealed class NavigationHost(val route: String) {
    data object InitNavHost : NavigationHost("navigation_host")
}
