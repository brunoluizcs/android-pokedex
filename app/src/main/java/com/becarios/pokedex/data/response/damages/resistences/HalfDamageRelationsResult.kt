package com.becarios.pokedex.data.response.damages.resistences

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HalfDamageRelationsResult(
    val half_damage_from: List<HalfDamageResult>
)