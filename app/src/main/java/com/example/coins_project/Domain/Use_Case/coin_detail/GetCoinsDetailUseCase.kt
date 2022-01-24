package com.example.coins_project.Domain.Use_Case.coin_detail

import android.util.Log
import com.example.coins_project.Common.Resources
import com.example.coins_project.Data.Remote.Dto.CoinsDetailDto
import com.example.coins_project.Data.Remote.Dto.toCoins
import com.example.coins_project.Data.Remote.Dto.toCoinsDetail
import com.example.coins_project.Domain.Model.Coins
import com.example.coins_project.Domain.Model.CoinsDetail
import com.example.coins_project.Domain.Repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCoinsDetailUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resources<CoinsDetail>> = flow {
        try {
            val coin = repository.getCoinsById(coinId).toCoinsDetail()
            emit(Resources.Sucess<CoinsDetail>(coin))
        } catch (e: Exception) {
            Log.e("message", e.message.toString())
        }

    }
}