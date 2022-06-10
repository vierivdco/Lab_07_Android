package com.cervantes.poketinder.data

import com.cervantes.poketinder.data.database.dao.PokemonDao
import com.cervantes.poketinder.data.database.entities.MyPokemonEntity
import com.cervantes.poketinder.data.model.PokemonListModel
import com.cervantes.poketinder.data.model.PokemonModel
import com.cervantes.poketinder.data.network.PokemonService
import com.cervantes.poketinder.domain.model.MyPokemon
import com.cervantes.poketinder.domain.model.Pokemon
import com.cervantes.poketinder.domain.model.PokemonDetail
import com.cervantes.poketinder.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService,

    private val pokemonDao: PokemonDao
) {
    suspend fun getAllPokemonFromApi(): List<Pokemon>{
        val listResponse: PokemonListModel=pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map {it.toDomain()}
    }

    suspend fun getPokemonByIdFromApi(idPokemon:String): PokemonDetail {
        val response =pokemonService.getPokemonsById(idPokemon)
        return response.ToDomain()
    }

    suspend fun getMyPokemonsFromDatabase():List<MyPokemon>{
        val response:List<MyPokemonEntity> = pokemonDao.getAllPokemons()
        return response.map{it.toDomain()}
    }

    suspend fun insertMyPokemon(myPokemon:MyPokemonEntity){
        pokemonDao.insert(myPokemon)
    }
}