package com.example.coins_project.Di

import androidx.lifecycle.SavedStateHandle
import com.example.coins_project.Common.Constants
import com.example.coins_project.Data.Remote.Api
import com.example.coins_project.Data.Repository.CoinsRepositoryImpl
import com.example.coins_project.Domain.Repository.CoinRepository
import com.example.coins_project.Domain.Use_Case.coin_detail.GetCoinsDetailUseCase
import com.example.coins_project.Domain.Use_Case.coin_list.GetCoinsUseCase
import com.example.coins_project.Presentation.Coin_Detail.CoinDetailVIewModel
import com.example.coins_project.Presentation.Coin_List.CoinListVIewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val AppModule = module {

    fun provideRepository(api: Api): CoinRepository {
        return CoinsRepositoryImpl(api)
    }

    fun getRetrofitRequest(): Api {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)

    }

    fun getUseCase(repository: CoinRepository): GetCoinsUseCase {
        return GetCoinsUseCase(repository)
    }

    fun getDeatilUseCase(repository: CoinRepository): GetCoinsDetailUseCase {
        return GetCoinsDetailUseCase(repository)
    }

    fun getSaveHandle(): SavedStateHandle {
        return SavedStateHandle()
    }

    single { getSaveHandle() }
    single { getDeatilUseCase(get()) }
    single { getUseCase(get()) }
    single { provideRepository(get()) }
    single { getRetrofitRequest() }
}

val CoinListViewModel = module {
    viewModel {
        CoinListVIewModel(get())
    }
}

val CoinDetailViewModel = module {
    viewModel {
        CoinDetailVIewModel(get())
    }
}
