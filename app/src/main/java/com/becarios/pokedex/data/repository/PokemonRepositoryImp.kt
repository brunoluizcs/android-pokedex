package com.becarios.pokedex.data.repository

import com.becarios.pokedex.data.model.Pokemons
import com.becarios.pokedex.data.service.PokemonService

class PokemonRepositoryImp(private val service: PokemonService) : PokemonsRepository {

    suspend override fun getPokemonList(offset: Int?): List<Pokemons> {
        var limitPokemons = 49

        val list = mutableListOf<Pokemons>()

        val limit = offset ?: 0

        for (pokemon: Int in 0..limitPokemons) {
            val index = pokemon + limit + 1
            val pokemonsType = service.getPokemonsById(index)
            val pokemon = Pokemons(
                id = pokemonsType.id,
                name = pokemonsType.name,
                typeName1 = pokemonsType.types[0].type.name,
                typeName2 = pokemonsType.types.last().type.name
            )

            list.add(pokemon)
        }
        return list.toList()
    }
}