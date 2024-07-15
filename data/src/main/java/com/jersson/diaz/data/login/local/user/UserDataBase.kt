package com.jersson.diaz.data.login.local.user

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jersson.diaz.data.login.local.accounts.dao.AccountsDao
import com.jersson.diaz.data.login.local.accounts.model.DbAccounts
import com.jersson.diaz.data.login.local.movements.dao.MovementsDao
import com.jersson.diaz.data.login.local.movements.model.DbMovements
import com.jersson.diaz.data.login.local.user.dao.UserDao
import com.jersson.diaz.data.login.local.user.model.DbUser

@Database(
    entities = [
        DbUser::class,
        DbAccounts::class,
        DbMovements::class
    ],
    version = 2
)
abstract class LosAndesDataBase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun accountsDao(): AccountsDao
    abstract fun movementsDao(): MovementsDao
}