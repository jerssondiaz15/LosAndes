package com.jersson.diaz.losandes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun Routing(
    navController: NavController,
    uiEvents: SharedFlow<UIEvents>,
){
    LaunchedEffect(key1 = null) {
        uiEvents.collect{ uiEvents ->
            when(uiEvents) {
                UIEvents.GoAccounts -> {
                    navController.navigate(NavigationScreen.AccountScreen.screen)
                }
                UIEvents.GoDetail -> {
                    navController.navigate(NavigationScreen.DetailScreen.screen)
                }
            }
        }
    }
}