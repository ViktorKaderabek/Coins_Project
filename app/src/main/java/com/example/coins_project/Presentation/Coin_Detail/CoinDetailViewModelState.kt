package com.example.coins_project.Presentation.Coin_Detail

import com.example.coins_project.Domain.Model.Coins
import com.example.coins_project.Domain.Model.CoinsDetail

data class CoinDetailViewModelState(
    val isLoading : Boolean = false,
    val coinsDetail : CoinsDetail? = null,
    val error : String? = null
)