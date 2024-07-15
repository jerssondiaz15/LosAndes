package com.jersson.diaz.losandes.ui.account

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.util.Function
import com.jersson.diaz.domain.model.Account
import com.jersson.diaz.losandes.R
import com.jersson.diaz.losandes.theme.GreenAndroid
import com.jersson.diaz.losandes.theme.accountAmountDetail
import com.jersson.diaz.losandes.theme.accountDetail
import com.jersson.diaz.losandes.utils.getAccountAmount
import com.jersson.diaz.losandes.utils.getAccountType

@Composable
fun AccountItem(
    account: Account,
    goDetail: Function<Account, Unit>,
) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clickable {
                goDetail.apply(account)
            },
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.White,
            disabledContainerColor = Color.White,
            disabledContentColor = Color.White,
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(48.dp),
                painter = painterResource(id = R.drawable.ic_android_logo),
                contentDescription = null,
                tint = GreenAndroid,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .weight(2f)
            ) {
                Text(
                    text = stringResource(id = getAccountType(account.currency)),
                    style = accountDetail,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = getAccountAmount(account.currency, account.amount),
                    style = accountAmountDetail,
                    maxLines = 1
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(6.dp))
}