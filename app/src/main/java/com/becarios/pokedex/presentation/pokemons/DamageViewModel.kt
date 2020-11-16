package com.becarios.pokedex.presentation.pokemons

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.becarios.pokedex.data.model.PokemonsDamage
import com.becarios.pokedex.data.response.damages.weaknesses.DamageBody
import com.becarios.pokedex.data.service.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DamageViewModel : ViewModel() {
    val mmLiveData: MutableLiveData<List<PokemonsDamage>> = MutableLiveData()
    val pokemonsList2: MutableList<PokemonsDamage> = mutableListOf()

    fun getDamage(type: Int) {

        APIService.service.getDamage(type).enqueue(object : Callback<DamageBody> {
            override fun onResponse(call: Call<DamageBody>, response: Response<DamageBody>) {
                if (response.isSuccessful) {
                    Log.e("SAPI", "Sussesso API!!!")
                    response.body()?.let { damage ->
                        var damageSize = damage.damage_relations.double_damage_from.size
                        var halfDamageSize = damage.damage_relations.half_damage_from.size

                        if (damageSize == 1 && halfDamageSize == 0) {
                            val pokemonDamage = PokemonsDamage(
                                name0 = damage.damage_relations.double_damage_from[0].name,
                            )
                            pokemonsList2.add(pokemonDamage)
                        }
                        if (damageSize == 2 && halfDamageSize == 2) {
                            val pokemonDamage = PokemonsDamage(
                                name0 = damage.damage_relations.double_damage_from[0].name,
                                name1 = damage.damage_relations.double_damage_from[1].name,
                                name3 = damage.damage_relations.half_damage_from[0].name,
                                name4 = damage.damage_relations.half_damage_from[1].name
                            )
                            pokemonsList2.add(pokemonDamage)
                        }
                        if (damageSize == 1 && halfDamageSize > 2) {
                            val pokemonDamage = PokemonsDamage(
                                name0 = damage.damage_relations.double_damage_from[0].name,
                                name3 = damage.damage_relations.half_damage_from[0].name,
                                name4 = damage.damage_relations.half_damage_from[1].name,
                                name5 = damage.damage_relations.half_damage_from[2].name
                            )
                            pokemonsList2.add(pokemonDamage)
                        }
                        if (damageSize == 2 && halfDamageSize > 2) {
                            val pokemonDamage = PokemonsDamage(
                                name0 = damage.damage_relations.double_damage_from[0].name,
                                name1 = damage.damage_relations.double_damage_from[1].name,
                                name3 = damage.damage_relations.half_damage_from[0].name,
                                name4 = damage.damage_relations.half_damage_from[1].name,
                                name5 = damage.damage_relations.half_damage_from[2].name
                            )
                            pokemonsList2.add(pokemonDamage)
                        }
                        if (damageSize > 2 && halfDamageSize == 1) {
                            val pokemonDamage = PokemonsDamage(
                                name0 = damage.damage_relations.double_damage_from[0].name,
                                name1 = damage.damage_relations.double_damage_from[1].name,
                                name2 = damage.damage_relations.double_damage_from[2].name,
                                name3 = damage.damage_relations.half_damage_from[0].name
                            )
                            pokemonsList2.add(pokemonDamage)
                        }
                        if (damageSize > 2 && halfDamageSize == 2) {
                            val pokemonDamage = PokemonsDamage(
                                name0 = damage.damage_relations.double_damage_from[0].name,
                                name1 = damage.damage_relations.double_damage_from[1].name,
                                name2 = damage.damage_relations.double_damage_from[2].name,
                                name3 = damage.damage_relations.half_damage_from[0].name,
                                name4 = damage.damage_relations.half_damage_from[1].name
                            )
                            pokemonsList2.add(pokemonDamage)
                        }
                        if (damageSize > 2 && halfDamageSize > 2) {
                            val pokemonDamage = PokemonsDamage(
                                name0 = damage.damage_relations.double_damage_from[0].name,
                                name1 = damage.damage_relations.double_damage_from[1].name,
                                name2 = damage.damage_relations.double_damage_from[2].name,
                                name3 = damage.damage_relations.half_damage_from[0].name,
                                name4 = damage.damage_relations.half_damage_from[1].name,
                                name5 = damage.damage_relations.half_damage_from[2].name
                            )
                            pokemonsList2.add(pokemonDamage)
                        }
                    }
                }
                mmLiveData.value = pokemonsList2
            }
            override fun onFailure(call: Call<DamageBody>, t: Throwable) {
                Log.e("ErroAPI ", t.message.toString())
            }
        })
    }
}