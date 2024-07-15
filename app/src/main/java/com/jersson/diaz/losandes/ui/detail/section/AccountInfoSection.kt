package com.jersson.diaz.losandes.ui.detail.section

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jersson.diaz.domain.model.Account
import com.jersson.diaz.losandes.R
import com.jersson.diaz.losandes.theme.GreenAndroid
import com.jersson.diaz.losandes.theme.accountAmountDetail
import com.jersson.diaz.losandes.theme.accountDetail
import com.jersson.diaz.losandes.theme.accountHeadboard
import com.jersson.diaz.losandes.utils.getAccountAmount
import com.jersson.diaz.losandes.utils.getAccountType

@Composable
fun AccountInfoSection(
    account: Account = Account(),
) {
    val context = LocalContext.current

    val copyTextToClipboard = {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("simple text", account.numberAccount)
        clipboard.setPrimaryClip(clip)
    }
    val copyMessage = stringResource(id = R.string.detail_copy)

    Text(
        text = stringResource(id = R.string.detail_title),
        style = accountHeadboard
    )
    Spacer(modifier = Modifier.height(10.dp))
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.White,
            disabledContainerColor = Color.White,
            disabledContentColor = Color.White,
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
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
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Column(
                    modifier = Modifier
                        .weight(2f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.detail_account_number),
                        style = accountDetail,
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = account.numberAccount,
                        style = accountAmountDetail,
                        maxLines = 1
                    )
                }
                Button(
                    modifier = Modifier.height(40.dp),
                    shape = RoundedCornerShape(24.dp),
                    onClick = {
                        copyTextToClipboard.invoke()
                        Toast.makeText(context, copyMessage, Toast.LENGTH_LONG).show()
                    }
                ) {
                    Text(text = stringResource(id = R.string.login_enter))
                }
            }
        }
    }
}