package com.becarios.pokedex.presentation.pokemons

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.becarios.pokedex.data.model.Pokemons
import com.becarios.pokedex.data.model.PokemonsId
import com.becarios.pokedex.data.repository.PokemonIdRepository
import com.becarios.pokedex.data.repository.PokemonsRepository
import com.google.firebase.crashlytics.FirebaseCrashlytics
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val pokemonsRepository: PokemonsRepository,
    private val pokemonIdRepository: PokemonIdRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO) : ViewModel() {
    private val scope = CoroutineScope(dispatcher)
    val mLiveData: MutableLiveData<List<Pokemons>> = MutableLiveData()
    val _mLiveData: MutableLiveData<List<PokemonsId>> = MutableLiveData()

    fun getPokemons() {
        scope.launch {
            try {
                val list = mLiveData.value
                val response = pokemonsRepository.getPokemonList(list?.size)

                if (list != null) {
                    var mutList = list?.toMutableList()
                    mutList.addAll(response)
                    mLiveData.postValue(mutList.toList())
                } else {
                    mLiveData.postValue(response)
                }
            } catch (e: Exception) {
                FirebaseCrashlytics.getInstance().log("Erro genérico API")
            }
        }
    }

    fun getPokemonId(pokemonId: String) {
        scope.launch {
            try {
                val list = _mLiveData.value
                val response = pokemonIdRepository.getPokemonList(pokemonId)
                _mLiveData.postValue(response)

            } catch (e: Exception) {
                FirebaseCrashlytics.getInstance().log("Erro genérico API")
            }
        }
    }
}
