package com.jersson.diaz.losandes.ui.account.section

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.util.Function
import com.jersson.diaz.domain.model.Account
import com.jersson.diaz.losandes.R
import com.jersson.diaz.losandes.theme.accountHeadboard
import com.jersson.diaz.losandes.ui.account.AccountItem

@Composable
fun SuccessScreen(
    isVisible: Boolean,
    list: List<Account>,
    goDetail: Function<Account, Unit>,
){
    AnimatedVisibility(
        visibleState = MutableTransitionState(isVisible),
        enter = expandHorizontally(),
        exit = shrinkHorizontally()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = stringResource(id = R.string.list_title),
                style = accountHeadboard
            )
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn {
                items(items = list){ account ->
                    AccountItem(
                        account = account,
                        goDetail = goDetail
                    )
                }
            }
        }
    }
}