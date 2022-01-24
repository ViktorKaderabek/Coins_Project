package com.example.coins_project.Domain.Repository

import com.example.coins_project.Data.Remote.Dto.CoinsDto

interface CoinRepository {

    suspend fun getListOfCoins(): List<CoinsDto>
}