package com.example.bojiapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bojiapp.databinding.ActivityMainBinding
import com.example.bojiapp.repository.recycler.GameAdapter
import com.example.bojiapp.view.GameViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Observer

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val gameViewModel: GameViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Recycler
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        gameViewModel.getAllGames()

        gameViewModel.games.observe(this, androidx.lifecycle.Observer { games ->
            binding.recyclerView.adapter = GameAdapter(games)
        })
    }
}