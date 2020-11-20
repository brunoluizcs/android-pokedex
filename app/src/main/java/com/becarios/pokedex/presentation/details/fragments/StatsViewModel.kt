package com.becarios.pokedex.presentation.details.fragments

import android.util.Log
import androidx.lifecycle.*
import com.becarios.pokedex.data.model.PokemonsStats
import com.becarios.pokedex.data.response.stats.PokemonStats
import com.becarios.pokedex.data.service.APIService
import retrofit2.*

class StatsViewModel : ViewModel() {
    val mLiveData: MutableLiveData<List<PokemonsStats>> = MutableLiveData()
    val pokemonsList: MutableList<PokemonsStats> = mutableListOf()

    fun getStats(pokemonId: String, pokemonType: String) {

        APIService.service.getStats(pokemonId).enqueue(object : Callback<PokemonStats> {
            override fun onResponse(call: Call<PokemonStats>, response: Response<PokemonStats>) {
                if (response.isSuccessful) {
                    response.body()?.let { stats ->

                        for (results in stats.stats) {
                            val pokemonStats = PokemonsStats(
                                base_stat1 = results.base_stat,
                                name = results.stat.name,
                                pokemonType = pokemonType
                            )
                            pokemonsList.add(pokemonStats)
                        }
                    }
                    mLiveData.value = pokemonsList
                }
            }
            override fun onFailure(call: Call<PokemonStats>, t: Throwable) {
                Log.e("Erro API ", t.message.toString())
            }
        })
    }
}