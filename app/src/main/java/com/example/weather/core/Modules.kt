package com.example.weather.core

import com.example.weather.data.InteractorImpl
import com.example.weather.data.MainRepositoryImpl
import com.example.weather.domain.Interactor
import com.example.weather.domain.MainApi
import com.example.weather.domain.MainRepository
import com.example.weather.presentation.MainViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val coreModule = module {

    single<Retrofit> {

        Retrofit.Builder()
            .baseUrl(MyApp.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }

    single<Gson> {
        GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
            .setLenient()
            .create()
    }

}

val viewmodels = module {
    viewModel { MainViewModel(get()) }
}

val serviceModule = module {
    single { get<Retrofit>().create(MainApi::class.java) }

}

val repositoies = module {
    single<MainRepository> { MainRepositoryImpl(get()) }
}

val interactors = module {
    single<Interactor> { InteractorImpl(get()) }
}
