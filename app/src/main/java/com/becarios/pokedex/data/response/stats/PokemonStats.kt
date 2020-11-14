package com.becarios.pokedex.data.response.stats

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonStats (
    val stats: List<PokemonStatsResult>
)