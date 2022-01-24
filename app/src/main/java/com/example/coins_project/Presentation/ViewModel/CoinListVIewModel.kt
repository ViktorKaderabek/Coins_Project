package com.example.coins_project.Presentation.ViewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coins_project.Common.Resources
import com.example.coins_project.Domain.Use_Case.GetCoinsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CoinListVIewModel(
    private val usecase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ViewModelState())
    val state: State<ViewModelState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        usecase().onEach { result ->
            when (result) {
                is Resources.Loading -> {
                    _state.value = ViewModelState(isLoading = true)
                }
                is Resources.Sucess -> {
                    _state.value = ViewModelState(coinsList = result.data ?: emptyList())
                }
                is Resources.Error -> {
                    _state.value = ViewModelState(error = "An Error has occured")
                }
            }
        }.launchIn(viewModelScope)
    }

}