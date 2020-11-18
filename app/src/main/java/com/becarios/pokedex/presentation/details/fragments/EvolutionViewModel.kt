package com.becarios.pokedex.presentation.details.fragments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.becarios.pokedex.data.model.EvolutionChain
import com.becarios.pokedex.data.model.EvolutionChain2
import com.becarios.pokedex.data.response.species.Chain
import com.becarios.pokedex.data.response.species.EvolutionChainBody
import com.becarios.pokedex.data.service.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EvolutionViewModel : ViewModel() {

    val mLiveData: MutableLiveData<List<EvolutionChain>> = MutableLiveData()
    val pokemonsList: MutableList<EvolutionChain> = mutableListOf()
    val mLiveData2: MutableLiveData<List<EvolutionChain2>> = MutableLiveData()
    val pokemonsList2: MutableList<EvolutionChain2> = mutableListOf()

    fun getEvolution(id: String) {

        APIService.service.getSpecies(id).enqueue(object : Callback<EvolutionChainBody> {
            override fun onResponse(
                call: Call<EvolutionChainBody>,
                response: Response<EvolutionChainBody>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { speciesEvolution ->
                        for (results in speciesEvolution.evolution_chain.url) {
                            val evolution = EvolutionChain(
                                url = speciesEvolution.evolution_chain.url
                            )
                            pokemonsList.add(evolution)
                        }
                    }
                    mLiveData.value = pokemonsList
                }
            }

            override fun onFailure(call: Call<EvolutionChainBody>, t: Throwable) {
                Log.e("Erro API ", t.message.toString())
            }
        })
    }

    fun getEvolutionChain(id: String) {

        APIService.service.getEvolution(id).enqueue(object : Callback<Chain> {
            override fun onResponse(call: Call<Chain>, response: Response<Chain>) {
                if (response.isSuccessful) {
                    response.body()?.let { evolutionResult ->
                        if (evolutionResult.chain.evolves_to.isNullOrEmpty()){
                            for (i in evolutionResult.chain.species.name) {
                                val evolution1 = EvolutionChain2(
                                    name1 = evolutionResult.chain.species.name,
                                    url1 = evolutionResult.chain.species.url,
                                    name2 = "",
                                    url2 = "",
                                    status = "notFound"
                                )
                                pokemonsList2.add(evolution1)
                            }
                        } else if (evolutionResult.chain.evolves_to[0].evolves_to.isNotEmpty()) {
                            for (i in 1..3) {
                                when (i) {
                                    1 -> {
                                        val evolution1 = EvolutionChain2(
                                            name1 = evolutionResult.chain.species.name,
                                            url1 = evolutionResult.chain.species.url,
                                            name2 = evolutionResult.chain.evolves_to[0].species.name,
                                            url2 = evolutionResult.chain.evolves_to[0].species.url,
                                            status = "foundEvo2"
                                        )
                                        pokemonsList2.add(evolution1)
                                    }
                                    2 -> {
                                        val evolution1 = EvolutionChain2(
                                            name1 = evolutionResult.chain.evolves_to[0].species.name,
                                            url1 = evolutionResult.chain.evolves_to[0].species.url,
                                            name2 = evolutionResult.chain.evolves_to[0].evolves_to[0].species.name,
                                            url2 = evolutionResult.chain.evolves_to[0].evolves_to[0].species.url,
                                            status = "foundEvo2"
                                        )
                                        pokemonsList2.add(evolution1)

                                    }
                                }
                            }
                        } else {
                            for (i in 1..2) {
                                val evolution1 = EvolutionChain2(
                                    name1 = evolutionResult.chain.species.name,
                                    url1 = evolutionResult.chain.species.url,
                                    name2 = evolutionResult.chain.evolves_to[0].species.name,
                                    url2 = evolutionResult.chain.evolves_to[0].species.url,
                                    status = "foundEvo1"
                                )

                                pokemonsList2.add(evolution1)
                            }
                        }

                    }
                    mLiveData2.value = pokemonsList2
                }
            }

            override fun onFailure(call: Call<Chain>, t: Throwable) {
                Log.e("Erro API ", t.message.toString())
            }

        })
    }
}