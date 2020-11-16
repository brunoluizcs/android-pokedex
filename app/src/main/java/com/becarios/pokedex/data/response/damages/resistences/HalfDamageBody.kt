package com.becarios.pokedex.data.response.damages.resistences

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HalfDamageBody(
    val damage_relations: List<HalfDamageRelationsResult>
)