package com.jersson.diaz.losandes.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jersson.diaz.domain.model.Transactions
import com.jersson.diaz.domain.model.TypeTransaction
import com.jersson.diaz.losandes.theme.accountDateDetail
import com.jersson.diaz.losandes.theme.accountDetail
import com.jersson.diaz.losandes.utils.getFormatAmount

@Composable
fun TransactionItem(
    transactions: Transactions
) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp),
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
            Column(
                modifier = Modifier
                    .weight(2f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = transactions.description,
                    style = accountDetail,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = transactions.date,
                    style = accountDateDetail,
                    maxLines = 1
                )
            }
            Text(
                text = "${transactions.currency.symbol} ${transactions.typeTransaction.description} ${getFormatAmount(transactions.amount)}",
                color = if (transactions.typeTransaction == TypeTransaction.ADD) Color.Red else Color.Green,
                fontSize = 18.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
    Spacer(modifier = Modifier.height(4.dp))
}