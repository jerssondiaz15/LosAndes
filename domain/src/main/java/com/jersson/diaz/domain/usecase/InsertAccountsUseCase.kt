package com.jersson.diaz.domain.usecase

import com.jersson.diaz.domain.repository.AccountsRepository
import javax.inject.Inject

class InsertAccountsUseCase @Inject constructor(
    private val accountsRepository: AccountsRepository
) {
    suspend operator fun invoke() {
        accountsRepository.insertAccounts()
    }
}