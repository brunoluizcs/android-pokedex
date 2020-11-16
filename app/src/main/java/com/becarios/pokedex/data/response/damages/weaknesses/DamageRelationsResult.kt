package com.becarios.pokedex.data.response.damages.weaknesses

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DamageRelationsResult(
    val double_damage_from: List<DamageResult>,
    val half_damage_from: List<HalfDamageResult>
)