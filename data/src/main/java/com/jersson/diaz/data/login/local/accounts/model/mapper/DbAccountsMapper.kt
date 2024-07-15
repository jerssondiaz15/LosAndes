package com.jersson.diaz.data.login.local.accounts.model.mapper

import com.jersson.diaz.data.login.local.accounts.model.DbAccounts
import com.jersson.diaz.domain.model.Account
import com.jersson.diaz.domain.model.Currency

fun DbAccounts.toDomain(): Account = with(this) {
    Account(
        numAccount = numAccount.toString(),
        currency = if (currency == "S/") Currency.PEN else Currency.USD,
        amount = totalAmount,
        numberAccount = numAccount.toString()
    )
}

fun List<DbAccounts>.toDomain(): List<Account> = this.map { it.toDomain() }