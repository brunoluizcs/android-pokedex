package com.becarios.pokedex.data.response.species

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpeciesResult2(
    val name: String,
    val url: String
)