package com.becarios.pokedex.presentation.details.fragments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.becarios.pokedex.data.model.PokemonsDescription
import com.becarios.pokedex.data.model.PokemonsDescription2
import com.becarios.pokedex.data.response.abilities.PokemonDescription
import com.becarios.pokedex.data.service.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DescriptionViewModel : ViewModel() {
    val mLiveData: MutableLiveData<List<PokemonsDescription>> = MutableLiveData()
    val pokemonsList: MutableList<PokemonsDescription> = mutableListOf()
    val mLiveData2: MutableLiveData<List<PokemonsDescription2>> = MutableLiveData()
    val pokemonsList2: MutableList<PokemonsDescription2> = mutableListOf()

    fun getDescription(url1: String, url2: String) {

        APIService.service.getDescription(url1).enqueue(object : Callback<PokemonDescription> {
            override fun onResponse(call: Call<PokemonDescription>, response: Response<PokemonDescription>) {
                if (response.isSuccessful) { response.body()?.let { description ->
                        for (results in description.effect_entries){
                            val pokemonDescription = PokemonsDescription(
                                effect = results.effect
                            )
                            pokemonsList.add(pokemonDescription)
                            getDescription2(url2)
                        }
                    }
                    mLiveData.value = pokemonsList
                }
            }

            override fun onFailure(call: Call<PokemonDescription>, t: Throwable) {
                Log.e("Erro API ", t.message.toString())
            }
        })
    }

    fun getDescription2(url2: String) {

        APIService.service.getDescription(url2).enqueue(object : Callback<PokemonDescription> {
            override fun onResponse(
                call: Call<PokemonDescription>, response: Response<PokemonDescription>) {
                if (response.isSuccessful) { response.body()?.let { description ->

                        for (results in description.effect_entries) {
                            val pokemonDescription2 = PokemonsDescription2(
                                effect = results.effect
                            )
                            pokemonsList2.add(pokemonDescription2)
                        }
                    }
                    mLiveData2.value = pokemonsList2
                }
            }
            override fun onFailure(call: Call<PokemonDescription>, t: Throwable) {
                Log.e("Erro API ", t.message.toString())
            }
        })
    }
}
