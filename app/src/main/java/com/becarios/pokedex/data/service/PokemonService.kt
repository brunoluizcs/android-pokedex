package com.becarios.pokedex.data.service

import com.becarios.pokedex.data.response.listagem.PokemonRootResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon?")
    fun getPokemons(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): retrofit2.Call<PokemonRootResponse>
    teste
}