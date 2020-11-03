package com.becarios.pokedex.data.response.listagem

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonRootResult(
    val name: String,
    val url: String
)