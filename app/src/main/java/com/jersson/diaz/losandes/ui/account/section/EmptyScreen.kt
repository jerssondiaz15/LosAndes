package com.jersson.diaz.losandes.ui.account.section

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jersson.diaz.losandes.R

@Composable
fun EmptyScreen(
    isVisible: Boolean,
){
    AnimatedVisibility(
        visibleState = MutableTransitionState(isVisible),
        enter = expandHorizontally(),
        exit = shrinkHorizontally()
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = stringResource(id = R.string.list_empty))
    }
}