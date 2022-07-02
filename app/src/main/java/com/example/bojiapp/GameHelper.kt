package com.example.bojiapp

import com.example.bojiapp.repository.model.GameModel

class GameHelper {
    companion object {
        fun emptyGameModel():GameModel{
            return GameModel(
                0,
            "",
            "",
            0,
            "",
            0,
            0,
            "",
            "",
            "",
            "",
            "")
        }
    }
}