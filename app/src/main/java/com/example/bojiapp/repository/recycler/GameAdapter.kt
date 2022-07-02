package com.example.bojiapp.repository.recycler

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.bojiapp.databinding.GameItemBinding
import com.example.bojiapp.repository.model.Game
import com.example.bojiapp.repository.model.GameModel
import com.example.bojiapp.view.GameDetail
import com.squareup.picasso.Picasso

const val GAMEID_MESSAGE = "com.example.bojiapp.GAMEID"
class GameAdapter(private val games:List<Game>):RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    class ViewHolder (val binding: GameItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GameItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game = games.get(position)
        with(holder.binding){
            tvNombre.text = game.nombre
            tvPrecio.text = game.precio.toString()
            tvEdad.text   = game.edad.toString()
            tvJugadores.text= game.jugadores
            Picasso.get().load(game.imagen).into(imageView)
        }
        holder.binding.root.setOnClickListener(View.OnClickListener {
            val intent = Intent(it.context, GameDetail::class.java).apply {
                putExtra(GAMEID_MESSAGE, game.id)
            }
            it.context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return games.size
    }
}