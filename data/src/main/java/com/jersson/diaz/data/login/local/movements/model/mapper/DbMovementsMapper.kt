package com.jersson.diaz.data.login.local.movements.model.mapper

import com.jersson.diaz.data.login.local.accounts.model.mapper.toDomain
import com.jersson.diaz.data.login.local.movements.model.DbMovements
import com.jersson.diaz.domain.model.Currency
import com.jersson.diaz.domain.model.Transactions
import com.jersson.diaz.domain.model.TypeTransaction

fun DbMovements.toDomain(): Transactions = with(this) {
    Transactions(
        description = description,
        date = date,
        amount = amount,
        currency = if (currency == "S/") Currency.PEN else Currency.USD,
        typeTransaction = if (typeTransaction == "+") TypeTransaction.ADD else TypeTransaction.LESS
    )
}

fun List<DbMovements>.toDomain(): List<Transactions> = this.map { it.toDomain() }