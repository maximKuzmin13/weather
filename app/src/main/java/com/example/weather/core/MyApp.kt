package com.example.weather.core

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp: Application() {

    companion object {
        const val SERVER_URL = "https://api.openweathermap.org/";
        const val API_KEY = "fcdec961d4bb3176a1978536a5eb19ab";
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidContext(this@MyApp)

            modules(
                listOf(
                        coreModule,
                        serviceModule,
                        repositoies,
                        interactors,
                        viewmodels,
                        daoModule
                )
            )
        }

    }
}