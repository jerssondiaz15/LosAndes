package com.jersson.diaz.losandes.model

import com.jersson.diaz.domain.model.Account
import com.jersson.diaz.domain.model.Transactions

data class AccountState(
    val list: List<Account> = listOf(),
    val accountSelected: Account = Account(),
    val transactionsList: List<Transactions> = listOf()
)