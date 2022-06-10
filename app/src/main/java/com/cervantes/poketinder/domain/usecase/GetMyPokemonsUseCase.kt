package com.cervantes.poketinder.domain.usecase

import com.cervantes.poketinder.data.PokemonRepository
import com.cervantes.poketinder.domain.model.MyPokemon
import javax.inject.Inject

class GetMyPokemonsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke():List<MyPokemon>{
        return pokemonRepository.getMyPokemonsFromDatabase()
    }
}