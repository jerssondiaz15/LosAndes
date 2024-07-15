package com.jersson.diaz.data.login.local.accounts

import com.jersson.diaz.data.login.local.accounts.datasource.AccountsDatabaseDataSource
import com.jersson.diaz.data.login.local.accounts.model.DbAccounts
import com.jersson.diaz.data.login.local.accounts.model.mapper.toDomain
import com.jersson.diaz.domain.model.Account
import com.jersson.diaz.domain.model.Currency
import com.jersson.diaz.domain.repository.AccountsRepository
import javax.inject.Inject

class AccountsRepositoryImpl @Inject constructor(
    private val accountsDatabaseDataSource: AccountsDatabaseDataSource
): AccountsRepository {
    override suspend fun getListDbAccounts(): List<Account> = accountsDatabaseDataSource.getListDbAccounts().toDomain()

    override suspend fun insertAccounts() {
        val dbAccountsList = listOf(
            DbAccounts(
                currency = Currency.PEN.symbol,
                totalAmount = 1000.80,
                numAccount = 111111111,
            ),
            DbAccounts(
                currency = Currency.USD.symbol,
                totalAmount = 1600.20,
                numAccount = 22222222
            )
        )
        dbAccountsList.map { dbAccounts->
            accountsDatabaseDataSource.insertAccounts(dbAccounts)
        }
    }

    override suspend fun insertAccountsRefresh(
        currency: String,
        totalAmount: Double,
        numAccount: Int
    ) {
        accountsDatabaseDataSource.insertAccounts(
            DbAccounts(
                currency = currency,
                totalAmount = totalAmount,
                numAccount = numAccount
            )
        )
    }
}