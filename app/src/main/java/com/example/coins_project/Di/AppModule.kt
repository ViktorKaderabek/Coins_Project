package com.example.coins_project.Di

import com.example.coins_project.Common.Constants
import com.example.coins_project.Data.Remote.CoinPaprikaApi
import com.example.coins_project.Data.Repository.CoinsRepositoryImpl
import com.example.coins_project.Domain.Repository.CoinRepository
import com.example.coins_project.Domain.Use_Case.coin_list.GetCoinsUseCase
import com.example.coins_project.Presentation.Coin_List.CoinListVIewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val AppModule = module {

    fun provideRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinsRepositoryImpl(api)
    }

    fun getRetrofitRequest(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)

    }

    fun getUseCase(repository: CoinRepository): GetCoinsUseCase {
        return GetCoinsUseCase(repository)
    }

    single { getUseCase(get()) }
    single { provideRepository(get()) }
    single { getRetrofitRequest() }
}

val ViewModel = module {
    viewModel {
        CoinListVIewModel(get())
    }
}