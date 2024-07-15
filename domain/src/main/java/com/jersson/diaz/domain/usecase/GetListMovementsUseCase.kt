package com.jersson.diaz.domain.usecase

import com.jersson.diaz.domain.model.Transactions
import com.jersson.diaz.domain.repository.MovementsRepository
import javax.inject.Inject

class GetListMovementsUseCase @Inject constructor(
    private val movementsRepository: MovementsRepository
) {
    suspend fun invoke(numAccount: String): List<Transactions> = movementsRepository.getListDbMovements(numAccount)
}