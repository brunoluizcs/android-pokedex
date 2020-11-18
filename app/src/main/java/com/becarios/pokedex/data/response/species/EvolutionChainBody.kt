package com.becarios.pokedex.data.response.species

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EvolutionChainBody(
    val evolution_chain: EvolutionChainResults
)