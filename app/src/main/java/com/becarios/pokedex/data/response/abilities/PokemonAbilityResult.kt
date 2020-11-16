package com.becarios.pokedex.data.response.abilities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonAbilityResult (
    val name: String,
    val url: String
)