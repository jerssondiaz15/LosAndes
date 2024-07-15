package com.jersson.diaz.data.login.local.accounts.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
data class DbAccounts (
    @PrimaryKey(autoGenerate = true) val numAccount: Int = 0,
    val totalAmount: Double,
    val currency: String
)