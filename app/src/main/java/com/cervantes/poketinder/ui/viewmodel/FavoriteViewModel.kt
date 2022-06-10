package com.cervantes.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cervantes.poketinder.domain.model.MyPokemon
import com.cervantes.poketinder.domain.usecase.GetMyPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getMyPokemonsUseCase: GetMyPokemonsUseCase
): ViewModel() {
    val myPokemonList = MutableLiveData<List<MyPokemon>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getMyPokemonsUseCase()
            if (result.isNotEmpty()){
                myPokemonList.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}