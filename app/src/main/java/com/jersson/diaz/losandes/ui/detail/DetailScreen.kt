package com.jersson.diaz.losandes.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jersson.diaz.domain.model.Account
import com.jersson.diaz.domain.model.Transactions
import com.jersson.diaz.losandes.ui.detail.section.AccountInfoSection
import com.jersson.diaz.losandes.ui.detail.section.ListSection

@Composable
fun DetailScreen(
    account: Account,
    transactionList: List<Transactions>
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
    ) {
        AccountInfoSection(account)

        ListSection(transactionList)
    }
}