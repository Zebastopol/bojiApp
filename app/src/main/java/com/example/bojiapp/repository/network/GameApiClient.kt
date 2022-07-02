package com.example.bojiapp.repository.network

import com.example.bojiapp.repository.model.GameModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GameApiClient {

    @GET("board_games")
    suspend fun listGames(): Response<List<GameModel>>

    @GET("board_games/{id}")
    suspend fun gameDetail(@Path("id") libroId:Int): Response<GameModel>

}