package com.becarios.pokedex.data.response.listagem

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class PokemonRootResponse(
    val results: List<PokemonRootResult>
)