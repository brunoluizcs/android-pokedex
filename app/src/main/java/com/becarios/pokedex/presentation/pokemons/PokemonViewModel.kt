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
    val pokemonsList: MutableList<Pokemons> = mutableListOf()
    val _mLiveData: MutableLiveData<List<PokemonsId>> = MutableLiveData()

    var pokemonCount = 1
    val limit = 51
    var progress = false

    fun getPokemon() {

        APIService.service.getPokemonsId(pokemonCount)
            .enqueue(
                object : Callback<PokemonRootResponse> {
                    override fun onResponse(
                        call: Call<PokemonRootResponse>,
                        response: Response<PokemonRootResponse>
                    ) {
                        if (response.isSuccessful) {
                            response.body()?.let { pokemonsType ->

                                val pokemon = Pokemons(
                                    id = pokemonsType.id,
                                    name = pokemonsType.name,
                                    typeName1 = pokemonsType.types[0].type.name,
                                    typeName2 = pokemonsType.types.last().type.name
                                )

                                pokemonCount++
                                if (pokemonCount <= limit) {
                                    pokemonsList.add(pokemon)
                                    getPokemon()
                                } else {
                                    progress = true
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

       APIService.service.getPokemonId(pokemonId)
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
                                    id = pokemonsResponse.id,
                                    typeName1 = pokemonsResponse.types[0].type.name,
                                    typeName2 = pokemonsResponse.types.last().type.name
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
