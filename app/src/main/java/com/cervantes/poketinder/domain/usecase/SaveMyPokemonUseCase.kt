package com.cervantes.poketinder.domain.usecase

import com.cervantes.poketinder.data.PokemonRepository
import com.cervantes.poketinder.data.database.entities.toDatabase
import com.cervantes.poketinder.domain.model.MyPokemon
import javax.inject.Inject

class SaveMyPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository) {

    suspend operator fun invoke(myPokemon: MyPokemon) {
        pokemonRepository.insertMyPokemon(myPokemon.toDatabase())
    }
}