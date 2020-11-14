package com.becarios.pokedex.data.response.stats

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonStatsResult (

    val base_stat: String,
    val stat: PokemonStatsResultName

)
