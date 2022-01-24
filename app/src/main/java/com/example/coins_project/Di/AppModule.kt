package com.example.coins_project.Di

import com.example.coins_project.Common.Constants
import com.example.coins_project.Data.Remote.CoinPaprikaApi
import com.example.coins_project.Data.Repository.CoinsRepositoryImpl
import com.example.coins_project.Domain.Repository.CoinRepository
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

    single {provideRepository(get())}
    single { getRetrofitRequest()}

}