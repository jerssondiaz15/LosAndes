package com.jersson.diaz.domain.model

class Movements (
    val id: Int,
    val description: String,
    val date: String,
    val amount: Double,
    val currency: String,
    val typeTransaction: String
)