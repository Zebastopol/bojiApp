package com.example.bojiapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.bojiapp.repository.model.Game

@Entity(tableName = "games")
data class GameEntity (
    @PrimaryKey override val id:Int,
    override val nombre:String,
    override val imagen:String,
    override val precio:String,
    override val jugadores:String,
    override val edad:String,
    override val año:Int?,
    override val tiempoJuego:String,
    override val descripcion:String,
    override val link:String,
    override val diseño:String,
    override val artista:String,
    override val editor:String,

    ): Game


