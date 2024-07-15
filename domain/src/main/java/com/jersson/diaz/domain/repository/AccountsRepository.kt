package com.jersson.diaz.domain.repository

import com.jersson.diaz.domain.model.Account

interface AccountsRepository {
    suspend fun getListDbAccounts(): List<Account>
    suspend fun insertAccounts()
    suspend fun insertAccountsRefresh(currency: String, totalAmount: Double, numAccount: Int)
}