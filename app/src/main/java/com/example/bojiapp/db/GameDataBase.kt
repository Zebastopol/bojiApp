package com.example.bojiapp.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GameEntity::class], version = 1)
abstract class GameDataBase: RoomDatabase() {
    abstract fun gameDao():GameDao
}