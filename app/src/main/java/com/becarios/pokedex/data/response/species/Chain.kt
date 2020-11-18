package com.becarios.pokedex.data.response.species

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Chain(
    val chain: ChainBody,
    val id: String
)