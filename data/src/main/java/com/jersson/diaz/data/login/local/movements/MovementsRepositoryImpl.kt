package com.jersson.diaz.data.login.local.movements

import com.jersson.diaz.data.login.local.movements.datasource.MovementsDatabaseDataSource
import com.jersson.diaz.data.login.local.movements.model.DbMovements
import com.jersson.diaz.data.login.local.movements.model.mapper.toDomain
import com.jersson.diaz.domain.model.Currency
import com.jersson.diaz.domain.model.Transactions
import com.jersson.diaz.domain.model.TypeTransaction
import com.jersson.diaz.domain.repository.MovementsRepository
import javax.inject.Inject

class MovementsRepositoryImpl @Inject constructor(
    private val movementsDatabaseDataSource: MovementsDatabaseDataSource
): MovementsRepository {
    override suspend fun getListDbMovements(numAccount: String): List<Transactions> = movementsDatabaseDataSource.getListDbMovements(numAccount).toDomain()

    override suspend fun insertMovements() {
        val dbMovementsList = listOf(
            DbMovements(
                numAccount = "111111111",
                description = "Plin",
                date = "25 Nov 2021",
                amount = 10.0,
                currency = Currency.PEN.symbol,
                typeTransaction = TypeTransaction.LESS.description,
            ),
            DbMovements(
                numAccount = "111111111",
                description = "Transferencia",
                date = "25 Nov 2021",
                amount = 6.10,
                currency = Currency.PEN.symbol,
                typeTransaction = TypeTransaction.ADD.description,
            ),
            DbMovements(
                numAccount = "22222222",
                description = "Transferencia",
                date = "25 Nov 2021",
                amount = 6.10,
                currency = Currency.PEN.symbol,
                typeTransaction = TypeTransaction.ADD.description,
            )
        )
        dbMovementsList.map { dbMovements ->
            movementsDatabaseDataSource.insertMovements(dbMovements)
        }
    }

}