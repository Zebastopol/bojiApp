package com.example.bojiapp.db

import androidx.room.*

@Dao
interface GameDao {

    @Query("SELECT * FROM games")
    fun getAll() : List<GameEntity>

    @Query("SELECT * FROM games WHERE id = :lid")
    fun findById(lid:Int):GameEntity

    @Query("DELETE FROM games")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg libros:GameEntity)

    @Delete
    fun delete(game:GameEntity)
}