package com.cervantes.poketinder.domain.usecase

import com.cervantes.poketinder.data.PokemonRepository
import com.cervantes.poketinder.domain.model.PokemonDetail
import javax.inject.Inject

class GetMyPokemonDetailUseCase @Inject constructor(
    private val repository: PokemonRepository
){
    suspend operator fun invoke(): PokemonDetail {
        return repository.getPokemonByIdFromApi("1")
    }
}