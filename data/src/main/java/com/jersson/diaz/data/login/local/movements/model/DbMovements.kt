package com.jersson.diaz.data.login.local.movements.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "movements"
)
data class DbMovements (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val numAccount: String,
    val description: String,
    val date: String,
    val amount: Double,
    val currency: String,
    val typeTransaction: String,
)