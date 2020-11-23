package com.becarios.pokedex.data.repository

import com.becarios.pokedex.data.model.Pokemons

interface PokemonsRepository {
    suspend fun getPokemonList(offset: Int? = null) : List<Pokemons>
}