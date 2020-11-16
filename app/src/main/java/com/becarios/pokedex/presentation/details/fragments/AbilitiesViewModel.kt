package com.becarios.pokedex.presentation.details.fragments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.becarios.pokedex.data.model.PokemonsAbilities
import com.becarios.pokedex.data.model.PokemonsDescription
import com.becarios.pokedex.data.response.abilities.PokemonAbilities
import com.becarios.pokedex.data.service.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AbilitiesViewModel : ViewModel() {
    val mLiveData: MutableLiveData<List<PokemonsAbilities>> = MutableLiveData()
    val pokemonsList: MutableList<PokemonsAbilities> = mutableListOf()
    val mLiveData2: MutableLiveData<List<PokemonsDescription>> = MutableLiveData()
    val pokemonsList2: MutableList<PokemonsDescription> = mutableListOf()

    fun getAbilities(pokemonId: String) {

        APIService.service.getAbilities(pokemonId).enqueue(object : Callback<PokemonAbilities> {
            override fun onResponse(call: Call<PokemonAbilities>, response: Response<PokemonAbilities>) {
                if (response.isSuccessful) { response.body()?.let { abilities ->

                        for (results in abilities.abilities){
                            val pokemonAbilities = PokemonsAbilities(
                                name1 = results.ability.name,
                                url1 = results.ability.url,
                                name2 = results.ability.name,
                                url2= results.ability.url
                            )
                            pokemonsList.add(pokemonAbilities)
                        }
                    }
                    mLiveData.value = pokemonsList
                }
            }

            override fun onFailure(call: Call<PokemonAbilities>, t: Throwable) {
                Log.e("Erro API ", t.message.toString())
            }
        })
    }
}