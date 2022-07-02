package com.example.bojiapp.di

import android.content.Context
import androidx.room.Room
import com.example.bojiapp.db.GameDao
import com.example.bojiapp.db.GameDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun dataBase(@ApplicationContext appContext: Context):GameDataBase {
        return Room
            .databaseBuilder(
                appContext,
                GameDataBase::class.java,
                "games-db"
            )
            .build()
    }

    @Provides
    @Singleton
    fun gameDao(dataBase: GameDataBase): GameDao {
        return dataBase.gameDao()
    }

}