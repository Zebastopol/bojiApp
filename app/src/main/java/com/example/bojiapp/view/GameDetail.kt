package com.example.bojiapp.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.bojiapp.databinding.ActivityGameDetailBinding
import com.example.bojiapp.repository.recycler.GAMEID_MESSAGE
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameDetail : AppCompatActivity() {

    private lateinit var binding: ActivityGameDetailBinding

    private val gameDetailViewModel: GameDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gameId = intent.getIntExtra(GAMEID_MESSAGE,0)
        gameDetailViewModel.getGamedetail(gameId)

        gameDetailViewModel.game.observe(this, Observer { game ->
            with(binding){
                tvDetalleNombre.text = game.nombre
                tvDetalleDescripcion.text = game.descripcion
                tvDetallePrecio.text = game.precio
                tvPlayernum.text = game.jugadores
                tvAgeDetail.text = game.edad
                tvTiempoJuego.text = game.tiempoJuego
                tvYearDetail.text = game.año.toString()
                tvDesign.text = game.diseño
                tvArtistaDetalle.text = game.artista
                tvEditorDetalle.text = game.editor
                tvLink.text = game.link
                Picasso.get().load(game.imagen).into(imgDetalle)
            }

            binding.btnMail.setOnClickListener{
                val  emailText = """
                Hola, 
                    
                Quisiera reservar el juego de mesa ${game.nombre} favor de contactarme
                a este correo o al siguiente número telefónico ___________.
                
                Espero con gusto su respuesta
                """.trimIndent()

                val intentMail = Intent(Intent.ACTION_SENDTO).apply {
                    type = "msage/rfc822" // fix para que funcione PARA (TO)
                    data = Uri.parse("mailto:")
                    val to:Array<String> = arrayOf("info@boji-games.cl")

                    putExtra(Intent.EXTRA_EMAIL, to)
                    putExtra(Intent.EXTRA_SUBJECT, "Quiero reservar este juego ${game.nombre}")
                    putExtra(Intent.EXTRA_TEXT, emailText)
                }

                startActivity(intentMail)
            }
            binding.btnPhone.setOnClickListener {
                val dialIntent = Intent(Intent.ACTION_DIAL)
                dialIntent.data = Uri.parse("Tel: " + "+569 #### # ###")
                startActivity(dialIntent)
            }

        })
    }
}