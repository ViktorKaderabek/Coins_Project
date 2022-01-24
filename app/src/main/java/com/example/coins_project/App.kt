package com.example.coins_project

import android.app.Application
import com.example.coins_project.Di.AppModule
import com.example.coins_project.Di.CoinDetailViewModel
import com.example.coins_project.Di.CoinListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(AppModule, CoinListViewModel, CoinDetailViewModel))
        }
    }
}