package com.becarios.pokedex.data.response.abilities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonDescription (
    val effect_entries: List<PokemonDescriptionResult>
)