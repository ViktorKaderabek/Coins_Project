package com.example.coins_project.Presentation.Coin_Detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coins_project.Common.Constants
import com.example.coins_project.Common.Resources
import com.example.coins_project.Domain.Use_Case.coin_detail.GetCoinsDetailUseCase
import com.example.coins_project.Domain.Use_Case.coin_list.GetCoinsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CoinDetailVIewModel(
    private val usecase: GetCoinsDetailUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailViewModelState())
    val state: State<CoinDetailViewModelState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoins(coinId)
        }
    }

    private fun getCoins(coinId: String) {
        usecase(coinId).onEach { result ->
            when (result) {
                is Resources.Sucess -> {
                    _state.value = CoinDetailViewModelState(coinsDetail = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}