package com.cervantes.poketinder.data

import com.cervantes.poketinder.data.model.PokemonListModel
import com.cervantes.poketinder.data.model.PokemonModel
import com.cervantes.poketinder.data.network.PokemonService
import com.cervantes.poketinder.domain.model.Pokemon
import com.cervantes.poketinder.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService
){
    suspend fun getAllPokemonFromApi(): List<Pokemon>{
        val listResponse: PokemonListModel = pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map {it.toDomain()}
    }
}