package com.becarios.pokedex.data.repository

import com.becarios.pokedex.data.model.PokemonsId

interface PokemonIdRepository {
    suspend fun getPokemonList(id: String) : List<PokemonsId>
}