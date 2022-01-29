package com.example.coins_project.Presentation.Coin_List

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coins_project.Common.Resources
import com.example.coins_project.Domain.Use_Case.coin_list.GetCoinsUseCase
import com.example.coins_project.Presentation.Screen
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.core.KoinApplication.Companion.init

class CoinListVIewModel(
    private val usecase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListViewModelState())
    val state: State<CoinListViewModelState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        usecase().onEach { result ->
            when (result) {
                is Resources.Sucess -> {
                    _state.value = CoinListViewModelState(coinsList = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }

}