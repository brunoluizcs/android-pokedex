package com.becarios.pokedex.presentation.pokemons

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.becarios.pokedex.data.model.Pokemons
import com.becarios.pokedex.data.model.PokemonsId
import com.becarios.pokedex.data.response.listagem.PokemonIdResult
import com.becarios.pokedex.data.response.listagem.PokemonRootResponse
import com.becarios.pokedex.data.service.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonViewModel : ViewModel() {
    val mLiveData: MutableLiveData<List<Pokemons>> = MutableLiveData()
    val _mLiveData: MutableLiveData<List<PokemonsId>> = MutableLiveData()
    var limit = 200
    var offset = 0

    fun getPokemon() {

        APIService.service.getPokemons(limit, offset)
            .enqueue(object : Callback<PokemonRootResponse> {
                override fun onResponse(
                    call: Call<PokemonRootResponse>,
                    response: Response<PokemonRootResponse>
                ) {
                    if (response.isSuccessful) {
                        val pokemonsList: MutableList<Pokemons> = mutableListOf()
                        response.body()?.let { pokemonsResponse ->

                            for (results in pokemonsResponse.results) {
                                val pokemon = Pokemons(
                                    name = results.name,
                                    url = results.url
                                )
                                pokemonsList.add(pokemon)
                            }
                        }
                        mLiveData.value = pokemonsList
                    }
                }

                override fun onFailure(call: Call<PokemonRootResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
    }

    fun getPokemonId(pokemonId: String) {

        APIService.service.getPokemonsId(pokemonId)
            .enqueue(object : Callback<PokemonIdResult> {
                override fun onResponse(
                    call: Call<PokemonIdResult>,
                    response: Response<PokemonIdResult>
                ) {
                    if (response.isSuccessful) {
                        val pokemonsList: MutableList<PokemonsId> = mutableListOf()
                        response.body()?.let { pokemonsResponse ->

                            for (results in pokemonsResponse.name) {
                                val pokemon = PokemonsId(
                                    name = pokemonsResponse.name,
                                    id = pokemonsResponse.id
                                )
                                pokemonsList.add(pokemon)
                            }
                        }
                        _mLiveData.value = pokemonsList
                    }
                }

                override fun onFailure(call: Call<PokemonIdResult>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
    }
}
