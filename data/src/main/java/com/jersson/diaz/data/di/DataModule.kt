package com.jersson.diaz.data.di

import android.content.Context
import androidx.room.Room
import com.jersson.diaz.data.login.local.accounts.AccountsRepositoryImpl
import com.jersson.diaz.data.login.local.accounts.datasource.AccountsDatabaseDataSource
import com.jersson.diaz.data.login.local.movements.MovementsRepositoryImpl
import com.jersson.diaz.data.login.local.movements.datasource.MovementsDatabaseDataSource
import com.jersson.diaz.data.login.local.user.LosAndesDataBase
import com.jersson.diaz.data.login.local.user.UserRepositoryImpl
import com.jersson.diaz.data.login.local.user.datasource.UserDatabaseDataSource
import com.jersson.diaz.data.login.remote.AuthRepositoryImpl
import com.jersson.diaz.data.login.remote.network.ApiService
import com.jersson.diaz.domain.repository.AccountsRepository
import com.jersson.diaz.domain.repository.AuthRepository
import com.jersson.diaz.domain.repository.MovementsRepository
import com.jersson.diaz.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    private const val USER_DATABASE_NAME = "user_database"
    private const val ACCOUNTS_DATABASE_NAME = "accounts_database"
    private const val MOVEMENTS_DATABASE_NAME = "movements_database"

    private const val LOS_ANDES_NAME = "los_andes_database"

    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, LosAndesDataBase::class.java, USER_DATABASE_NAME)
            .build()

    @Provides
    @Singleton
    fun provideUserDao(losAndesDataBase: LosAndesDataBase) = losAndesDataBase.userDao()
    @Provides
    fun provideUserRepository(userDatabaseDataSource: UserDatabaseDataSource): UserRepository {
        return UserRepositoryImpl(userDatabaseDataSource)
    }
    @Provides
    fun provideUserDatabaseDataSource(losAndesDataBase: LosAndesDataBase): UserDatabaseDataSource {
        return UserDatabaseDataSource(losAndesDataBase)
    }

    /*
    @Provides
    @Singleton
    fun provideAccountsDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AccountsDataBase::class.java, ACCOUNTS_DATABASE_NAME)
            .build()
    */

    @Provides
    @Singleton
    fun provideAccountsDao(losAndesDataBase: LosAndesDataBase) = losAndesDataBase.accountsDao()
    @Provides
    fun provideAccountsRepository(accountsDatabaseDataSource: AccountsDatabaseDataSource): AccountsRepository {
        return AccountsRepositoryImpl(accountsDatabaseDataSource)
    }
    @Provides
    fun provideAccountsDatabaseDataSource(losAndesDataBase: LosAndesDataBase): AccountsDatabaseDataSource {
        return AccountsDatabaseDataSource(losAndesDataBase)
    }

    /*
    @Provides
    @Singleton
    fun provideMovementsDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MovementsDataBase::class.java, MOVEMENTS_DATABASE_NAME)
            .build()
    */

    @Provides
    @Singleton
    fun provideMovementsDao(losAndesDataBase: LosAndesDataBase) = losAndesDataBase.movementsDao()
    @Provides
    fun provideMovementsRepository(movementsDatabaseDataSource: MovementsDatabaseDataSource): MovementsRepository {
        return MovementsRepositoryImpl(movementsDatabaseDataSource)
    }
    @Provides
    fun provideMovementsDatabaseDataSource(losAndesDataBase: LosAndesDataBase): MovementsDatabaseDataSource {
        return MovementsDatabaseDataSource(losAndesDataBase)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
        builder.connectTimeout(1, TimeUnit.MINUTES)
        builder.readTimeout(1, TimeUnit.MINUTES)
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return builder.addInterceptor(loggingInterceptor).build()
    }
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fxservicesstaging.nunchee.com/api/1.0/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
    @Provides
    fun provideAuthRepository(apiService: ApiService): AuthRepository = AuthRepositoryImpl(apiService)
}