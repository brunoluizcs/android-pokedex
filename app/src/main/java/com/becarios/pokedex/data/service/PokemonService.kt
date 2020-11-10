package com.becarios.pokedex.data.service

import com.becarios.pokedex.data.response.listagem.PokemonIdResult
import com.becarios.pokedex.data.response.listagem.PokemonRootResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon/{characterId}")
    fun getPokemonId(
        @Path("characterId") characterId: String
    ): retrofit2.Call<PokemonIdResult>

    @GET("pokemon/{characterId}")
    fun getPokemonsId(
        @Path("characterId") characterId: Int
    ): Call<PokemonRootResponse>
}