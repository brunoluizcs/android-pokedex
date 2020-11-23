package com.becarios.pokedex.presentation.pokemons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.becarios.pokedex.data.repository.PokemonIdRepositoryImp
import com.becarios.pokedex.data.repository.PokemonRepositoryImp
import com.becarios.pokedex.data.service.APIService

class PokemonViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val pokemonRepository = PokemonRepositoryImp(APIService.service)
        val pokemonIdRepository = PokemonIdRepositoryImp(APIService.service)
        return PokemonViewModel(pokemonRepository, pokemonIdRepository) as T
    }
}