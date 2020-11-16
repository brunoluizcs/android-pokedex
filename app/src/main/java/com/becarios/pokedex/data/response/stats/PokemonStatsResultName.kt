package com.becarios.pokedex.data.response.stats

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonStatsResultName (
    val name: String
)