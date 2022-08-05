package com.example.bojiapp

import com.example.bojiapp.db.GameEntity
import com.example.bojiapp.repository.model.Game

class GameMapper {
    companion object {
        fun toEntity(libro: Game): GameEntity {
            with(libro) {
                return GameEntity(
                    id, nombre, imagen, precio, jugadores,
                    edad, año, tiempoJuego,descripcion,link,diseño,
                    artista, editor
                )
            }
        }
    }
}