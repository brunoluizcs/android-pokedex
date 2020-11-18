package com.becarios.pokedex.data.response.species

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EvolvesTo(
    val evolves_to: List<EvolvesTo2>,
    val species: SpeciesResult2
)