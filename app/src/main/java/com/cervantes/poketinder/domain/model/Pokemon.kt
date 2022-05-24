package com.cervantes.poketinder.domain.model

import com.cervantes.poketinder.data.model.PokemonModel
import com.cervantes.poketinder.util.getIdPokemonFromUrl
import java.io.Serializable

data class Pokemon(
    val name: String,
    val url: String
) : Serializable {
    fun getPokemonId() = getIdPokemonFromUrl(url)

    fun getPokemonImage(): String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${getPokemonId()}.png"
}

fun PokemonModel.toDomain() = Pokemon(name = name, url = url)
