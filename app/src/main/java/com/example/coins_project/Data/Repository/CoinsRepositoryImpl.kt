package com.example.coins_project.Data.Repository

import com.example.coins_project.Data.Remote.Api
import com.example.coins_project.Data.Remote.Dto.CoinsDetailDto
import com.example.coins_project.Data.Remote.Dto.CoinsDto
import com.example.coins_project.Domain.Repository.CoinRepository

class CoinsRepositoryImpl(
    private val api: Api
) : CoinRepository {

    override suspend fun getListOfCoins(): List<CoinsDto> {
        return api.getListOfCoins()
    }

    override suspend fun getCoinsById(coindId: String): CoinsDetailDto {
        return api.getCoinsById(coindId)
    }
}