package com.cervantes.poketinder.data.network

import com.cervantes.poketinder.data.model.PokemonListModel
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {

    @GET("?Limit=20")
    suspend fun getPokemons(): Response<PokemonListModel>
}