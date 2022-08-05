package com.example.bojiapp

import com.example.bojiapp.repository.model.GameModel

class GameHelper {
    companion object {
        fun emptyGameModel():GameModel{
            return GameModel(
                0,
                "sin datos",
                "sin datos",
                "sin datos",
                "sin datoss",
                "sin datos",
                0,
                "sin datos",
                "sin datos",
                "sin datos",
                "sin datos",
                "sin datos",
                "sin datos"
            )
        }
    }
}