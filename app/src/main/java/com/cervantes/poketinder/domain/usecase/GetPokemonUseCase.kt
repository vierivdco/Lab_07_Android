package com.cervantes.poketinder.domain.usecase

import com.cervantes.poketinder.data.PokemonRepository
import com.cervantes.poketinder.domain.model.Pokemon
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(private val repository: PokemonRepository) {
    suspend operator fun invoke():List<Pokemon> {
        return repository.getAllPokemonFromApi()
    }
}