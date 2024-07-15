package com.jersson.diaz.domain.usecase

import com.jersson.diaz.domain.repository.MovementsRepository
import javax.inject.Inject

class InsertMovementsUseCase @Inject constructor(
    private val movementsRepository: MovementsRepository
) {
    suspend operator fun invoke() = movementsRepository.insertMovements()
}