package com.example.bojiapp.repository.model

import com.google.gson.annotations.SerializedName

data class GameModel(

    @SerializedName("id") override val id:Int,
    @SerializedName("name") override val nombre: String,
    @SerializedName("image") override val imagen: String,
    @SerializedName("price") override val precio: Int,
    @SerializedName("players") override val jugadores: String,
    @SerializedName("age") override val edad: Int,
    @SerializedName("year") override val año: Int,
    @SerializedName("playing_time") override val tiempoJuego: String,
    @SerializedName("description") override val descripcion: String,
    @SerializedName("official_link") override val link: String,
    @SerializedName("Designer") override val diseño: String,
    @SerializedName("Artist") override val artista: String
):Game

/*data class Classification(
    @SerializedName("category") /*override*/ val categoria: String,
    @SerializedName("mechanisms") /*override*/ val mecanismos: String
)*/