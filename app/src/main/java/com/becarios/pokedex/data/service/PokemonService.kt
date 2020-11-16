package com.becarios.pokedex.data.service

import com.becarios.pokedex.data.response.abilities.PokemonAbilities
import com.becarios.pokedex.data.response.abilities.PokemonDescription
import com.becarios.pokedex.data.response.damages.weaknesses.DamageBody
import com.becarios.pokedex.data.response.listagem.PokemonIdResult
import com.becarios.pokedex.data.response.listagem.PokemonRootResponse
import com.becarios.pokedex.data.response.stats.PokemonStats
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET("pokemon/{pokemonId}") fun getPokemonId(@Path("pokemonId") pokemonId: String
    ): Call<PokemonIdResult>

    @GET("pokemon/{pokemonId}") fun getPokemonsId(@Path("pokemonId") pokemonId: Int
    ): Call<PokemonRootResponse>

    @GET("pokemon/{pokemonId}") fun getStats(@Path("pokemonId") pokemonId: String
    ): Call<PokemonStats>

    @GET("type/{typeId}") fun getDamage(@Path("typeId") typeId: Int
    ): Call<DamageBody>

    @GET("pokemon/{pokemonId}") fun getAbilities(@Path("pokemonId") pokemonId: String
    ): Call<PokemonAbilities>

    @GET("ability/{Id}") fun getDescription(@Path("Id") Id: String
    ): Call<PokemonDescription>
}