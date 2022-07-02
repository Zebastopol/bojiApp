package com.example.bojiapp.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bojiapp.repository.model.Game
import com.example.bojiapp.repository.network.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameDetailViewModel @Inject constructor(val repository: GameRepository): ViewModel() {

    val game = MutableLiveData<Game>()

    fun getGamedetail(id:Int) {
        viewModelScope.launch {
            val gameFromRepository = repository.findById(id)
            if( gameFromRepository != null) {
                game.postValue(gameFromRepository)
            }
        }
    }
}