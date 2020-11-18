package com.becarios.pokedex.data.response.species

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EvolutionChainResults(
    val url: String
)