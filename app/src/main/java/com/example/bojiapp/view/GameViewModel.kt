package com.example.bojiapp.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bojiapp.repository.model.Game
import com.example.bojiapp.repository.network.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.bojiapp.app.BojiApp

@HiltViewModel
class GameViewModel @Inject constructor(val repository: GameRepository): ViewModel() {

    val games = MutableLiveData<List<Game>>()

    fun getAllGames(){
        viewModelScope.launch {
            val gamesFromRepository = repository.findAll()
            if( !gamesFromRepository.isNullOrEmpty() ) {
                games.postValue(gamesFromRepository)
            }
        }
    }
}