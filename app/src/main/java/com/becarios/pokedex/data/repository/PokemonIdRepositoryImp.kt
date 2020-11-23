package com.becarios.pokedex.data.repository

import com.becarios.pokedex.data.model.PokemonsId
import com.becarios.pokedex.data.service.PokemonService

class PokemonIdRepositoryImp(private val service: PokemonService) : PokemonIdRepository {

    suspend override fun getPokemonList(id: String): List<PokemonsId> {
        var limitPokemons = 49

        val list = mutableListOf<PokemonsId>()


            val pokemonsType = service.getPokemonById(id)
            val pokemon = PokemonsId(
                id = pokemonsType.id,
                name = pokemonsType.name,
                typeName1 = pokemonsType.types[0].type.name,
                typeName2 = pokemonsType.types.last().type.name
            )

            list.add(pokemon)

        return list.toList()
    }
}