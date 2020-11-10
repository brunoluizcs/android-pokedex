package com.becarios.pokedex.data.response.listagem

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonIdResult(
    val name: String,
    val id: String,
    val types: List<PokemonRootResult>
)