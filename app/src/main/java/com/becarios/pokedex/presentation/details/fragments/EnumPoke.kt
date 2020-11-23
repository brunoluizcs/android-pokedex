package com.becarios.pokedex.presentation.details.fragments

import com.becarios.pokedex.R
import util.convertString

enum class EnumPoke(
    type: String,
    val color: Int,
    val typeName: String,
    val typeDrawable: Int,
    val fundoDrawable: Int,
    val backgroundCircle: Int
) {

    FIRE(
        R.string.Fire.convertString(),
        R.color.fire,
        "fogo",
        R.drawable.fire,
        R.drawable.fundo_fire,
        R.drawable.circle_fire
    ),
    WATER(
        R.string.Water.convertString(),
        R.color.water,
        "água",
        R.drawable.water,
        R.drawable.fundo_water,
        R.drawable.circle_water
    ),
    DRAGON(
        R.string.Dragon.convertString(),
        R.color.dragon,
        "dragão",
        R.drawable.dragon,
        R.drawable.fundo_dragon,
        R.drawable.circle_dragon
    ),
    FLYING(
        R.string.Flying.convertString(),
        R.color.flying,
        "voador",
        R.drawable.flying,
        R.drawable.fundo_flying,
        R.drawable.circle_flying
    ),
    GHOST(
        R.string.Ghost.convertString(),
        R.color.ghost,
        "fantasma",
        R.drawable.ghost,
        R.drawable.fundo_ghost,
        R.drawable.circle_ghost
    ),
    POISON(
        R.string.Poison.convertString(),
        R.color.poison,
        "veneno",
        R.drawable.poison,
        R.drawable.fundo_poison,
        R.drawable.circle_poison
    ),
    GRASS(
        R.string.Grass.convertString(),
        R.color.grass,
        "planta",
        R.drawable.grass,
        R.drawable.fundo_grass,
        R.drawable.circle_grass
    ),
    GROUND(
        R.string.Ground.convertString(),
        R.color.ground,
        "terra",
        R.drawable.ground,
        R.drawable.fundo_ground,
        R.drawable.circle_ground
    ),
    NORMAL(
        R.string.Normal.convertString(),
        R.color.normal,
        "normal",
        R.drawable.normal,
        R.drawable.fundo_normal,
        R.drawable.circle_normal
    ),
    PSYCHIC(
        R.string.Psychic.convertString(),
        R.color.psychic,
        "psíquico",
        R.drawable.psychic,
        R.drawable.fundo_psychic,
        R.drawable.circle_psychic
    ),
    FAIRY(
        R.string.Fairy.convertString(),
        R.color.fairy,
        "fada",
        R.drawable.fairy,
        R.drawable.fundo_fairy,
        R.drawable.circle_fairy
    ),
    ROCK(
        R.string.Rock.convertString(),
        R.color.rock,
        "rocha",
        R.drawable.rock,
        R.drawable.fundo_rock,
        R.drawable.circle_rock
    ),
    STEEL(
        R.string.Steel.convertString(),
        R.color.steel,
        "metal",
        R.drawable.iron,
        R.drawable.fundo_steel,
        R.drawable.circle_iron
    ),
    DARK(
        R.string.Dark.convertString(),
        R.color.dark,
        "sombra",
        R.drawable.dark,
        R.drawable.fundo_dark,
        R.drawable.circle_dark
    ),
    BUG(
        R.string.Bug.convertString(),
        R.color.bug,
        "inseto",
        R.drawable.bug,
        R.drawable.fundo_bug,
        R.drawable.circle_bug
    ),
    ELECTRIC(
        R.string.Electric.convertString(),
        R.color.electric,
        "elétrico",
        R.drawable.electric,
        R.drawable.fundo_electric,
        R.drawable.circle_electric
    ),
    FIGHTING(
        R.string.Fighting.convertString(),
        R.color.fight,
        "lutador",
        R.drawable.fighting,
        R.drawable.fundo_fight,
        R.drawable.circle_fighting
    ),
    ICE(
        R.string.Ice.convertString(),
        R.color.ice,
        "gelo",
        R.drawable.ice,
        R.drawable.fundo_ice,
        R.drawable.circle_ice
    );


}