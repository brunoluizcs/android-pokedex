package com.becarios.pokedex.presentation.pokemons

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.becarios.pokedex.data.model.Pokemons
import com.becarios.pokedex.data.model.PokemonsDamage
import com.becarios.pokedex.data.model.PokemonsId
import com.becarios.pokedex.data.response.listagem.PokemonIdResult
import com.becarios.pokedex.data.response.listagem.PokemonRootResponse
import com.becarios.pokedex.data.service.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonViewModel : ViewModel() {
    val mLiveData: MutableLiveData<List<Pokemons>> = MutableLiveData()
    val mmLiveData: MutableLiveData<List<PokemonsDamage>> = MutableLiveData()
    val pokemonsList: MutableList<Pokemons> = mutableListOf()
    val pokemonsList2: MutableList<PokemonsDamage> = mutableListOf()
    val _mLiveData: MutableLiveData<List<PokemonsId>> = MutableLiveData()


    var pokemonId = 1
    val limitPokemons = 20

    fun getPokemon() {
        APIService.service.getPokemonsId(pokemonId).enqueue(object : Callback<PokemonRootResponse> {
                    override fun onResponse(call: Call<PokemonRootResponse>, response: Response<PokemonRootResponse>) {
                        if (response.isSuccessful) {
                            response.body()?.let { pokemonsType ->

                                val pokemon = Pokemons(
                                    id = pokemonsType.id,
                                    name = pokemonsType.name,
                                    typeName1 = pokemonsType.types[0].type.name,
                                    typeName2 = pokemonsType.types.last().type.name
                                )

                                if (pokemonId <= limitPokemons) {
                                    pokemonsList.add(pokemon)
                                    pokemonId++
                                    getPokemon()
                                }
                            }
                            mLiveData.value = pokemonsList
                        }
                    }

                    override fun onFailure(call: Call<PokemonRootResponse>, t: Throwable) {
                        Log.e("Erro API ", t.message.toString())
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
                    Log.e("Erro API ", t.message.toString())
                }
            })
    }

    fun getPokemonPage(limitPage: Int) {

        APIService.service.getPokemonsId(pokemonId)
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

                                if (pokemonId <= limitPage) {
                                    pokemonsList.add(pokemon)
                                    pokemonId++
                                    getPokemonPage(limitPage)
                                }
                            }
                        }
                    }

                    override fun onFailure(call: Call<PokemonRootResponse>, t: Throwable) {
                        Log.e("Erro API ", t.message.toString())
                    }
                })
    }
}
