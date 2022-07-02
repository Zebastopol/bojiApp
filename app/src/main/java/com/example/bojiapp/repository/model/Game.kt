package com.example.bojiapp.repository.model



interface Game {
    val id:Int
    val nombre:String
    val imagen:String
    val precio:Int?
    val jugadores:String
    val edad:Int?
    val año:Int?
    val tiempoJuego:String
    val descripcion:String
    val link:String
    val diseño:String
    val artista:String

}