package com.example.coins_project.Presentation.Coin_List

import com.example.coins_project.Domain.Model.Coins

data class CoinListViewModelState(
    val coinsList: List<Coins> = emptyList()
)