package com.becarios.pokedex.data.response.species

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChainBody(
    val evolves_to: List<EvolvesTo>,
    val species: SpeciesResult1
)