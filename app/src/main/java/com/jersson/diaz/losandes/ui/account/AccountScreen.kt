package com.jersson.diaz.losandes.ui.account

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.util.Function
import com.jersson.diaz.domain.model.Account
import com.jersson.diaz.losandes.model.UiStateHolder
import com.jersson.diaz.losandes.ui.account.section.EmptyScreen
import com.jersson.diaz.losandes.ui.account.section.ErrorScreen
import com.jersson.diaz.losandes.ui.account.section.LoadingScreen
import com.jersson.diaz.losandes.ui.account.section.SuccessScreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListScreen(
    list: List<Account>,
    goDetail: Function<Account, Unit>,
    uiState: UiStateHolder,
    finish: Runnable,
    refresh: Runnable
) {

    val refreshState = rememberPullRefreshState(
        refreshing = uiState.isLoadingVisible,
        onRefresh = {
            refresh.run()
        }
    )
    BackHandler {
        finish.run()
    }

    Column(
        modifier = Modifier
            .pullRefresh(refreshState)
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.Start,
    ) {
        PullRefreshIndicator(modifier = Modifier.align(Alignment.CenterHorizontally), refreshing = uiState.isLoadingVisible, state = refreshState)
        EmptyScreen(uiState.isEmptyVisible)

        ErrorScreen(uiState.isErrorVisible)

        LoadingScreen(uiState.isLoadingVisible)

        SuccessScreen(uiState.isSuccessVisible, list, goDetail)
    }
}