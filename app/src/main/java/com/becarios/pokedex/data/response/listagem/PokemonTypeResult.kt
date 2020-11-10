package com.becarios.pokedex.data.response.listagem

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonTypeResult (

    val name: String

)
