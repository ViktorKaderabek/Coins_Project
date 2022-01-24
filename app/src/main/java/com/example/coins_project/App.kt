package com.example.coins_project

import android.app.Application
import com.example.coins_project.Di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            module { listOf(AppModule) }
        }
    }
}