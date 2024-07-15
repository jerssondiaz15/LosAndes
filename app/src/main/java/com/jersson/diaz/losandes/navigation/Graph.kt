package com.jersson.diaz.losandes.navigation

import androidx.navigation.compose.composable
import androidx.core.util.Function
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.jersson.diaz.domain.model.Account
import com.jersson.diaz.domain.model.User
import com.jersson.diaz.losandes.model.AccountState
import com.jersson.diaz.losandes.model.UiStateHolder
import com.jersson.diaz.losandes.ui.account.ListScreen
import com.jersson.diaz.losandes.ui.detail.DetailScreen
import com.jersson.diaz.losandes.ui.login.LoginScreen

fun NavGraphBuilder.graph(
    state: () -> AccountState,
    uiState: () -> UiStateHolder,
    validateUser: Function<User, Unit>,
    goDetail: Function<Account, Unit>,
    finish: Runnable,
    refresh: Runnable
) {
    navigation(
        startDestination = NavigationScreen.LoginScreen.screen,
        route = NavigationHost.InitNavHost.route
    ) {
        composable(NavigationScreen.LoginScreen.screen) {
            LoginScreen(
                validateUser = validateUser,
                uiState = uiState.invoke(),
            )
        }
        composable(NavigationScreen.AccountScreen.screen) {
            ListScreen(
                list = state().list,
                goDetail = goDetail,
                uiState = uiState.invoke(),
                finish = finish,
                refresh = refresh
            )
        }
        composable(NavigationScreen.DetailScreen.screen) {
            DetailScreen(
                account = state().accountSelected,
                transactionList = state().transactionsList
            )
        }
    }
}