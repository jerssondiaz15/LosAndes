package com.jersson.diaz.losandes.ui.account.section

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.jersson.diaz.losandes.R

@Composable
fun ErrorScreen(
    isVisible: Boolean,
){
    AnimatedVisibility(
        visibleState = MutableTransitionState(isVisible),
        enter = expandHorizontally(),
        exit = shrinkHorizontally()
    ) {
        Text(text = stringResource(id = R.string.list_error))
    }
}