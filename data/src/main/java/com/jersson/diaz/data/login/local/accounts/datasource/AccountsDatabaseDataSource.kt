package com.jersson.diaz.data.login.local.accounts.datasource

import com.jersson.diaz.data.login.local.accounts.model.DbAccounts
import com.jersson.diaz.data.login.local.user.LosAndesDataBase

class AccountsDatabaseDataSource(
    private val losAndesDataBase: LosAndesDataBase
) {
    suspend fun getListDbAccounts(): List<DbAccounts> = losAndesDataBase.accountsDao().getListDbAccounts()

    suspend fun insertAccounts(dbMovie: DbAccounts) = losAndesDataBase.accountsDao().insertAccounts(dbMovie)

}