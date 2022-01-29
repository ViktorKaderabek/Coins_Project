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
import com.example.coins_project.Presentation.Coin_List.CoinListScreen
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CoinDetailVIewModel(
    private val usecase: GetCoinsDetailUseCase

) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailViewModelState())
    val state: State<CoinDetailViewModelState> = _state
    private val coinId : String = CoinListScreen.coinId.toString()

    init {
        getCoins(coinId)
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