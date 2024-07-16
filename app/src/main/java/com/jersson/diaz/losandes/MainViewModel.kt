package com.jersson.diaz.losandes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jersson.diaz.domain.model.Account
import com.jersson.diaz.domain.model.Currency
import com.jersson.diaz.domain.model.ResultType
import com.jersson.diaz.domain.model.User
import com.jersson.diaz.domain.usecase.GetListAccountsUseCase
import com.jersson.diaz.domain.usecase.GetListMovementsUseCase
import com.jersson.diaz.domain.usecase.InsertAccountsRefreshUseCase
import com.jersson.diaz.domain.usecase.InsertAccountsUseCase
import com.jersson.diaz.domain.usecase.InsertMovementsUseCase
import com.jersson.diaz.domain.usecase.InsertUserUseCase
import com.jersson.diaz.domain.usecase.LoginUseCase
import com.jersson.diaz.losandes.navigation.UIEvents
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.jersson.diaz.losandes.model.AccountState
import com.jersson.diaz.losandes.model.MutableUiStateHolder
import com.jersson.diaz.losandes.model.UiState
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MainViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val getListAccountsUseCase: GetListAccountsUseCase,
    private val getListMovementsUseCase: GetListMovementsUseCase,
    private val insertAccountsUseCase: InsertAccountsUseCase,
    private val insertAccountsRefreshUseCase: InsertAccountsRefreshUseCase,
    private val insertMovementsUseCase: InsertMovementsUseCase,
    private val insertUserUseCase: InsertUserUseCase
): ViewModel() {

    private var _uiState = mutableStateOf(MutableUiStateHolder())
    val uiState: State<MutableUiStateHolder> = _uiState

    private var _events = MutableSharedFlow<UIEvents>()
    val events: SharedFlow<UIEvents>
        get() = _events

    private var _state = mutableStateOf(AccountState())

    val state: State<AccountState>
        get() = _state

    fun logIn(user: User){
        viewModelScope.launch {
            _uiState.value = uiState.value.copy(
                currentState = UiState.LOADING
            )
            when (val response = loginUseCase.invoke(user)) {
                is ResultType.Error -> {
                    _uiState.value = uiState.value.copy(
                        currentState = UiState.ERROR
                    )
                }
                is ResultType.Success -> {
                    insertUserUseCase.invoke(
                        id = response.value?.data?.user?._id ?:  "",
                        accessToken = response.value?.data?.accessToken ?: "",
                        expiresIn = response.value?.data?.expiresIn ?: ""
                    )
                    insertAccountsUseCase.invoke()
                    insertMovementsUseCase.invoke()
                    _events.emit(UIEvents.GoAccounts)
                    getData()
                }
            }
        }
    }

    private fun getData(){
        viewModelScope.launch {
            _uiState.value = uiState.value.copy(
                currentState = UiState.LOADING
            )
            delay(2000)
            val listAccount = getListAccountsUseCase.invoke()
            _state.value = state.value.copy(
                list = listAccount
            )
            _uiState.value = uiState.value.copy(
                currentState = UiState.from(state.value.list)
            )
            _uiState.value = uiState.value.copy(
                currentState = UiState.from(state.value.list)
            )
        }
    }

    fun goDetail(account: Account){
        viewModelScope.launch {
            val transactionsList = getListMovementsUseCase.invoke(account.numAccount)
            _state.value = state.value.copy(
                accountSelected = account,
                transactionsList = transactionsList,
            )
            _events.emit(UIEvents.GoDetail)
        }
    }

    fun refresh() {
        viewModelScope.launch {
            insertAccountsRefreshUseCase.invoke(currency = Currency.PEN.symbol, (1000..9999).random().toDouble(), (10000000..99999999).random())
            val listAccount = getListAccountsUseCase.invoke()
            _state.value = state.value.copy(
                list = listAccount
            )
        }
    }
}