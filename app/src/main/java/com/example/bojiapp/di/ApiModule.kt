package com.example.bojiapp.di

import com.example.bojiapp.repository.network.GameApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun baseUrl():String{
        return "https://board-games-fake-api.herokuapp.com/"
    }

    @Provides
    @Singleton
    fun retrofit(baseUrl:String):Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun libroAPI(retrofit:Retrofit):GameApiClient {
        return retrofit.create(GameApiClient::class.java)
    }

}