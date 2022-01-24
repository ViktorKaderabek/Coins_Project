package com.example.coins_project.Domain.Use_Case.coin_list

import com.example.coins_project.Common.Resources
import com.example.coins_project.Data.Remote.Dto.toCoins
import com.example.coins_project.Domain.Model.Coins
import com.example.coins_project.Domain.Repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCoinsUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resources<List<Coins>>> = flow {
        try {
            emit(Resources.Loading<List<Coins>>())
            val coins = repository.getListOfCoins().map { it.toCoins() }
            emit(Resources.Sucess<List<Coins>>(coins))
        } catch (e: HttpException) {
            emit(Resources.Error<List<Coins>>("Error has occured, check your internet connection"))
        } catch (e: IOException) {
            emit(Resources.Error<List<Coins>>("Error has occured, check your internet connection"))
        }

    }
}