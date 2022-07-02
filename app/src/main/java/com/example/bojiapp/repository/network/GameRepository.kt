package com.example.bojiapp.repository.network

import com.example.bojiapp.GameHelper
import com.example.bojiapp.GameMapper
import com.example.bojiapp.db.GameDao
import com.example.bojiapp.repository.model.Game
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameRepository @Inject constructor(
    val gameApiClient:GameApiClient,
    val gameDao: GameDao

) {
    suspend fun findById(id:Int): Game {
        return withContext(Dispatchers.IO) {
            val response = gameApiClient.gameDetail(id)
            if( response.isSuccessful ) {
                val game = response.body() ?: GameHelper.emptyGameModel()

                // cachear en BD
                gameDao.insertAll(GameMapper.toEntity(game))

                game
            } else {
                gameDao.findById(id)
            }
        }
    }

    suspend fun findAll():List<Game> {
        return withContext(Dispatchers.IO) {
            val response = gameApiClient.listGames()
            if( response.isSuccessful ) {
                val games = response.body() ?: emptyList()

                // borra cache antigua
                gameDao.deleteAll()
                // cachear datos en BD
                games.forEach { gameModel ->
                    gameDao.insertAll( GameMapper.toEntity(gameModel) )
                }

                games
            }else {
                gameDao.getAll()
            }
        }
    }

}