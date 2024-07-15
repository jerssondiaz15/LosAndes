package com.jersson.diaz.domain.usecase

import com.jersson.diaz.domain.model.Account
import com.jersson.diaz.domain.repository.AccountsRepository
import javax.inject.Inject

class GetListAccountsUseCase @Inject constructor(
    private val accountsRepository: AccountsRepository
) {
    suspend operator fun invoke(): List<Account> = accountsRepository.getListDbAccounts()
}