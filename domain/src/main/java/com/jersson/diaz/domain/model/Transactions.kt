package com.jersson.diaz.domain.model

class Transactions(
    val description: String,
    val date: String,
    val amount: Double,
    val currency: Currency,
    val typeTransaction: TypeTransaction,
)