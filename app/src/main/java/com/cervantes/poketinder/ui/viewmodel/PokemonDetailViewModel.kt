package com.cervantes.poketinder.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cervantes.poketinder.domain.usecase.GetMyPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel@Inject constructor(
    private val getMyPokemonDetailUseCase: GetMyPokemonDetailUseCase
): ViewModel(){
    fun onCreate(){
        viewModelScope.launch{
            val result=getMyPokemonDetailUseCase()
        }
    }
}