package com.becarios.pokedex.data.response.species

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpeciesResult3(
    val name: String,
    val url: String
)