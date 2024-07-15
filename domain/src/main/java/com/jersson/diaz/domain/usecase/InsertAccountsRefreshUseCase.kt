package com.jersson.diaz.domain.usecase

import com.jersson.diaz.domain.repository.AccountsRepository
import javax.inject.Inject

class InsertAccountsRefreshUseCase @Inject constructor(
    private val accountsRepository: AccountsRepository
) {
    suspend operator fun invoke(currency: String, totalAmount: Double, numAccount: Int) {
        accountsRepository.insertAccountsRefresh(currency, totalAmount, numAccount)
    }
}