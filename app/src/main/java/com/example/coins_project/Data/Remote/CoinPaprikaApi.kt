package com.example.coins_project.Data.Remote

import com.example.coins_project.Data.Remote.Dto.CoinsDetailDto
import com.example.coins_project.Data.Remote.Dto.CoinsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getListOfCoins(): List<CoinsDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinsById(@Path("coinId") coinId : String) : CoinsDetailDto
}