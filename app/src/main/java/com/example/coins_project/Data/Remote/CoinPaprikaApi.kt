package com.example.coins_project.Data.Remote

import com.example.coins_project.Data.Remote.Dto.CoinsDto
import retrofit2.http.GET

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getListOfCoins(): List<CoinsDto>
}