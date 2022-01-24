package com.example.coins_project.Data.Remote

import com.example.coins_project.Data.Remote.Dto.CoinsDto

interface CoinPaprikaApi {

    suspend fun getListOfCoins() : List<CoinsDto>
}