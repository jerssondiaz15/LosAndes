package com.jersson.diaz.domain.repository

import com.jersson.diaz.domain.model.Transactions

interface MovementsRepository {
    suspend fun getListDbMovements(numAccount: String): List<Transactions>
    suspend fun insertMovements()
}