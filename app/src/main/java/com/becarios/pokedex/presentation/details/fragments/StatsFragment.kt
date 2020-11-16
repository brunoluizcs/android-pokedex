package com.becarios.pokedex.presentation.details.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.becarios.pokedex.R
import com.becarios.pokedex.presentation.pokemons.DamageViewModel
import kotlinx.android.synthetic.main.fragment_stats.*
import java.util.*

class StatsFragment : Fragment() {
    var value = String()
    var pokemonType = String()
    var id = String()
    var damageType = 0

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
        val damageViewModel = ViewModelProvider(this).get(DamageViewModel::class.java)

        val statsViewModel: StatsViewModel = ViewModelProvider(this).get(StatsViewModel::class.java)
        statsViewModel.mLiveData.observe(this, Observer {

            it?.let { stats ->
                with(recyclerViewStats) {
                    layoutManager = GridLayoutManager(this@StatsFragment.context, 1)
                    setHasFixedSize(true)
                    adapter = StatsAdapter(stats) {
                    }
                }
            }
        })
        statsViewModel.getStats(value)

        damageViewModel.mmLiveData.observe(this, {
            it?.let { damage ->

                txtWeakness1.text = damage[0].name0.capitalize(Locale.ROOT)
                txtWeakness2.text = damage[0].name1.capitalize(Locale.ROOT)
                txtWeakness3.text = damage[0].name2.capitalize(Locale.ROOT)
                txtResist1.text = damage[0].name3.capitalize(Locale.ROOT)
                txtResist2.text = damage[0].name4.capitalize(Locale.ROOT)
                txtResist3.text = damage[0].name5.capitalize(Locale.ROOT)

                if (damage[0].name0.equals("")) {
                    weakness1.visibility = View.GONE
                    weakness1.visibility = View.GONE
                } else {
                    weakness1.visibility = View.VISIBLE
                    weakness1.visibility = View.VISIBLE
                }
                if (damage[0].name1.equals("")) {
                    weakness2.visibility = View.GONE
                    weakness2.visibility = View.GONE
                } else {
                    weakness2.visibility = View.VISIBLE
                    weakness2.visibility = View.VISIBLE
                }
                if (damage[0].name2.equals("")) {
                    weakness3.visibility = View.GONE
                    weakness3.visibility = View.GONE
                } else {
                    weakness3.visibility = View.VISIBLE
                    weakness3.visibility = View.VISIBLE
                }
                if (damage[0].name3.equals("")) {
                    resist1.visibility = View.GONE
                    resist1.visibility = View.GONE
                } else {
                    resist1.visibility = View.VISIBLE
                    resist1.visibility = View.VISIBLE
                }
                if (damage[0].name4.equals("")) {
                    resist2.visibility = View.GONE
                    resist2.visibility = View.GONE
                } else {
                    resist2.visibility = View.VISIBLE
                    resist2.visibility = View.VISIBLE
                }
                if (damage[0].name5.equals("")) {
                    resist3.visibility = View.GONE
                    resist3.visibility = View.GONE
                } else {
                    resist3.visibility = View.VISIBLE
                    resist3.visibility = View.VISIBLE
                }

                when (damage[0].name0) {
                    "fire" -> {
                        weakness1.setImageResource(R.drawable.fire)
                        weakness1.setBackgroundResource(R.drawable.circle_fire)
                    }
                    "water" -> {
                        weakness1.setImageResource(R.drawable.water)
                        weakness1.setBackgroundResource(R.drawable.circle_water)
                    }
                    "ice" -> {
                        weakness1.setImageResource(R.drawable.ice)
                        weakness1.setBackgroundResource(R.drawable.circle_ice)
                    }
                    "grass" -> {
                        weakness1.setImageResource(R.drawable.grass)
                        weakness1.setBackgroundResource(R.drawable.circle_grass)
                    }
                    "poison" -> {
                        weakness1.setImageResource(R.drawable.poison)
                        weakness1.setBackgroundResource(R.drawable.circle_poison)
                    }
                    "fighting" -> {
                        weakness1.setImageResource(R.drawable.fighting)
                        weakness1.setBackgroundResource(R.drawable.circle_fighting)
                    }
                    "rock" -> {
                        weakness1.setImageResource(R.drawable.rock)
                        weakness1.setBackgroundResource(R.drawable.circle_rock)
                    }
                    "flying" -> {
                        weakness1.setImageResource(R.drawable.flying)
                        weakness1.setBackgroundResource(R.drawable.circle_flying)
                    }
                    "dragon" -> {
                        weakness1.setImageResource(R.drawable.dragon)
                        weakness1.setBackgroundResource(R.drawable.circle_dragon)
                    }
                    "electric" -> {
                        weakness1.setImageResource(R.drawable.electric)
                        weakness1.setBackgroundResource(R.drawable.circle_electric)
                    }
                    "bug" -> {
                        weakness1.setImageResource(R.drawable.bug)
                        weakness1.setBackgroundResource(R.drawable.circle_bug)
                    }
                    "psychic" -> {
                        weakness1.setImageResource(R.drawable.psychic)
                        weakness1.setBackgroundResource(R.drawable.circle_psychic)
                    }
                    "ground" -> {
                        weakness1.setImageResource(R.drawable.ground)
                        weakness1.setBackgroundResource(R.drawable.circle_ground)
                    }
                    "fairy" -> {
                        weakness1.setImageResource(R.drawable.fairy)
                        weakness1.setBackgroundResource(R.drawable.circle_fairy)
                    }
                    "dark" -> {
                        weakness1.setImageResource(R.drawable.dark)
                        weakness1.setBackgroundResource(R.drawable.circle_dark)
                    }
                    "ghost" -> {
                        weakness1.setImageResource(R.drawable.ghost)
                        weakness1.setBackgroundResource(R.drawable.circle_ghost)
                    }
                    "steel" -> {
                        weakness1.setImageResource(R.drawable.iron)
                        weakness1.setBackgroundResource(R.drawable.circle_iron)
                    }
                    "normal" -> {
                        weakness1.setImageResource(R.drawable.normal)
                        weakness1.setBackgroundResource(R.drawable.circle_normal)
                    }
                }
                when (damage[0].name1) {
                    "fire" -> {
                        weakness2.setImageResource(R.drawable.fire)
                        weakness2.setBackgroundResource(R.drawable.circle_fire)
                    }
                    "water" -> {
                        weakness2.setImageResource(R.drawable.water)
                        weakness2.setBackgroundResource(R.drawable.circle_water)
                    }
                    "ice" -> {
                        weakness2.setImageResource(R.drawable.ice)
                        weakness2.setBackgroundResource(R.drawable.circle_ice)
                    }
                    "grass" -> {
                        weakness2.setImageResource(R.drawable.grass)
                        weakness2.setBackgroundResource(R.drawable.circle_grass)
                    }
                    "poison" -> {
                        weakness2.setImageResource(R.drawable.poison)
                        weakness2.setBackgroundResource(R.drawable.circle_poison)
                    }
                    "fighting" -> {
                        weakness2.setImageResource(R.drawable.fighting)
                        weakness2.setBackgroundResource(R.drawable.circle_fighting)
                    }
                    "rock" -> {
                        weakness2.setImageResource(R.drawable.rock)
                        weakness2.setBackgroundResource(R.drawable.circle_rock)
                    }
                    "flying" -> {
                        weakness2.setImageResource(R.drawable.flying)
                        weakness2.setBackgroundResource(R.drawable.circle_flying)
                    }
                    "dragon" -> {
                        weakness2.setImageResource(R.drawable.dragon)
                        weakness2.setBackgroundResource(R.drawable.circle_dragon)
                    }
                    "electric" -> {
                        weakness2.setImageResource(R.drawable.electric)
                        weakness2.setBackgroundResource(R.drawable.circle_electric)
                    }
                    "bug" -> {
                        weakness2.setImageResource(R.drawable.bug)
                        weakness2.setBackgroundResource(R.drawable.circle_bug)
                    }
                    "psychic" -> {
                        weakness2.setImageResource(R.drawable.psychic)
                        weakness2.setBackgroundResource(R.drawable.circle_psychic)
                    }
                    "ground" -> {
                        weakness2.setImageResource(R.drawable.ground)
                        weakness2.setBackgroundResource(R.drawable.circle_ground)
                    }
                    "fairy" -> {
                        weakness2.setImageResource(R.drawable.fairy)
                        weakness2.setBackgroundResource(R.drawable.circle_fairy)
                    }
                    "dark" -> {
                        weakness2.setImageResource(R.drawable.dark)
                        weakness2.setBackgroundResource(R.drawable.circle_dark)
                    }
                    "ghost" -> {
                        weakness2.setImageResource(R.drawable.ghost)
                        weakness2.setBackgroundResource(R.drawable.circle_ghost)
                    }
                    "steel" -> {
                        weakness2.setImageResource(R.drawable.iron)
                        weakness2.setBackgroundResource(R.drawable.circle_iron)
                    }
                    "normal" -> {
                        weakness2.setImageResource(R.drawable.normal)
                        weakness2.setBackgroundResource(R.drawable.circle_normal)
                    }
                }
                when (damage[0].name2) {
                    "fire" -> {
                        weakness3.setImageResource(R.drawable.fire)
                        weakness3.setBackgroundResource(R.drawable.circle_fire)
                    }
                    "water" -> {
                        weakness3.setImageResource(R.drawable.water)
                        weakness3.setBackgroundResource(R.drawable.circle_water)
                    }
                    "ice" -> {
                        weakness3.setImageResource(R.drawable.ice)
                        weakness3.setBackgroundResource(R.drawable.circle_ice)
                    }
                    "grass" -> {
                        weakness3.setImageResource(R.drawable.grass)
                        weakness3.setBackgroundResource(R.drawable.circle_grass)
                    }
                    "poison" -> {
                        weakness3.setImageResource(R.drawable.poison)
                        weakness3.setBackgroundResource(R.drawable.circle_poison)
                    }
                    "fighting" -> {
                        weakness3.setImageResource(R.drawable.fighting)
                        weakness3.setBackgroundResource(R.drawable.circle_fighting)
                    }
                    "rock" -> {
                        weakness3.setImageResource(R.drawable.rock)
                        weakness3.setBackgroundResource(R.drawable.circle_rock)
                    }
                    "flying" -> {
                        weakness3.setImageResource(R.drawable.flying)
                        weakness3.setBackgroundResource(R.drawable.circle_flying)
                    }
                    "dragon" -> {
                        weakness3.setImageResource(R.drawable.dragon)
                        weakness3.setBackgroundResource(R.drawable.circle_dragon)
                    }
                    "electric" -> {
                        weakness3.setImageResource(R.drawable.electric)
                        weakness3.setBackgroundResource(R.drawable.circle_electric)
                    }
                    "bug" -> {
                        weakness3.setImageResource(R.drawable.bug)
                        weakness3.setBackgroundResource(R.drawable.circle_bug)
                    }
                    "psychic" -> {
                        weakness3.setImageResource(R.drawable.psychic)
                        weakness3.setBackgroundResource(R.drawable.circle_psychic)
                    }
                    "ground" -> {
                        weakness3.setImageResource(R.drawable.ground)
                        weakness3.setBackgroundResource(R.drawable.circle_ground)
                    }
                    "fairy" -> {
                        weakness3.setImageResource(R.drawable.fairy)
                        weakness3.setBackgroundResource(R.drawable.circle_fairy)
                    }
                    "dark" -> {
                        weakness3.setImageResource(R.drawable.dark)
                        weakness3.setBackgroundResource(R.drawable.circle_dark)
                    }
                    "ghost" -> {
                        weakness3.setImageResource(R.drawable.ghost)
                        weakness3.setBackgroundResource(R.drawable.circle_ghost)
                    }
                    "steel" -> {
                        weakness3.setImageResource(R.drawable.iron)
                        weakness3.setBackgroundResource(R.drawable.circle_iron)
                    }
                    "normal" -> {
                        weakness3.setImageResource(R.drawable.normal)
                        weakness3.setBackgroundResource(R.drawable.circle_normal)
                    }
                }
                when (damage[0].name3) {
                    "fire" -> {
                        resist1.setImageResource(R.drawable.fire)
                        resist1.setBackgroundResource(R.drawable.circle_fire)
                    }
                    "water" -> {
                        resist1.setImageResource(R.drawable.water)
                        resist1.setBackgroundResource(R.drawable.circle_water)
                    }
                    "ice" -> {
                        resist1.setImageResource(R.drawable.ice)
                        resist1.setBackgroundResource(R.drawable.circle_ice)
                    }
                    "grass" -> {
                        resist1.setImageResource(R.drawable.grass)
                        resist1.setBackgroundResource(R.drawable.circle_grass)
                    }
                    "poison" -> {
                        resist1.setImageResource(R.drawable.poison)
                        resist1.setBackgroundResource(R.drawable.circle_poison)
                    }
                    "fighting" -> {
                        resist1.setImageResource(R.drawable.fighting)
                        resist1.setBackgroundResource(R.drawable.circle_fighting)
                    }
                    "rock" -> {
                        resist1.setImageResource(R.drawable.rock)
                        resist1.setBackgroundResource(R.drawable.circle_rock)
                    }
                    "flying" -> {
                        resist1.setImageResource(R.drawable.flying)
                        resist1.setBackgroundResource(R.drawable.circle_flying)
                    }
                    "dragon" -> {
                        resist1.setImageResource(R.drawable.dragon)
                        resist1.setBackgroundResource(R.drawable.circle_dragon)
                    }
                    "electric" -> {
                        resist1.setImageResource(R.drawable.electric)
                        resist1.setBackgroundResource(R.drawable.circle_electric)
                    }
                    "bug" -> {
                        resist1.setImageResource(R.drawable.bug)
                        resist1.setBackgroundResource(R.drawable.circle_bug)
                    }
                    "psychic" -> {
                        resist1.setImageResource(R.drawable.psychic)
                        resist1.setBackgroundResource(R.drawable.circle_psychic)
                    }
                    "ground" -> {
                        resist1.setImageResource(R.drawable.ground)
                        resist1.setBackgroundResource(R.drawable.circle_ground)
                    }
                    "fairy" -> {
                        resist1.setImageResource(R.drawable.fairy)
                        resist1.setBackgroundResource(R.drawable.circle_fairy)
                    }
                    "dark" -> {
                        resist1.setImageResource(R.drawable.dark)
                        resist1.setBackgroundResource(R.drawable.circle_dark)
                    }
                    "ghost" -> {
                        resist1.setImageResource(R.drawable.ghost)
                        resist1.setBackgroundResource(R.drawable.circle_ghost)
                    }
                    "steel" -> {
                        resist1.setImageResource(R.drawable.iron)
                        resist1.setBackgroundResource(R.drawable.circle_iron)
                    }
                    "normal" -> {
                        resist1.setImageResource(R.drawable.normal)
                        resist1.setBackgroundResource(R.drawable.circle_normal)
                    }
                }
                when (damage[0].name4) {
                    "fire" -> {
                        resist2.setImageResource(R.drawable.fire)
                        resist2.setBackgroundResource(R.drawable.circle_fire)
                    }
                    "water" -> {
                        resist2.setImageResource(R.drawable.water)
                        resist2.setBackgroundResource(R.drawable.circle_water)
                    }
                    "ice" -> {
                        resist2.setImageResource(R.drawable.ice)
                        resist2.setBackgroundResource(R.drawable.circle_ice)
                    }
                    "grass" -> {
                        resist2.setImageResource(R.drawable.grass)
                        resist2.setBackgroundResource(R.drawable.circle_grass)
                    }
                    "poison" -> {
                        resist2.setImageResource(R.drawable.poison)
                        resist2.setBackgroundResource(R.drawable.circle_poison)
                    }
                    "fighting" -> {
                        resist2.setImageResource(R.drawable.fighting)
                        resist2.setBackgroundResource(R.drawable.circle_fighting)
                    }
                    "rock" -> {
                        resist2.setImageResource(R.drawable.rock)
                        resist2.setBackgroundResource(R.drawable.circle_rock)
                    }
                    "flying" -> {
                        resist2.setImageResource(R.drawable.flying)
                        resist2.setBackgroundResource(R.drawable.circle_flying)
                    }
                    "dragon" -> {
                        resist2.setImageResource(R.drawable.dragon)
                        resist2.setBackgroundResource(R.drawable.circle_dragon)
                    }
                    "electric" -> {
                        resist2.setImageResource(R.drawable.electric)
                        resist2.setBackgroundResource(R.drawable.circle_electric)
                    }
                    "bug" -> {
                        resist2.setImageResource(R.drawable.bug)
                        resist2.setBackgroundResource(R.drawable.circle_bug)
                    }
                    "psychic" -> {
                        resist2.setImageResource(R.drawable.psychic)
                        resist2.setBackgroundResource(R.drawable.circle_psychic)
                    }
                    "ground" -> {
                        resist2.setImageResource(R.drawable.ground)
                        resist2.setBackgroundResource(R.drawable.circle_ground)
                    }
                    "fairy" -> {
                        resist2.setImageResource(R.drawable.fairy)
                        resist2.setBackgroundResource(R.drawable.circle_fairy)
                    }
                    "dark" -> {
                        resist2.setImageResource(R.drawable.dark)
                        resist2.setBackgroundResource(R.drawable.circle_dark)
                    }
                    "ghost" -> {
                        resist2.setImageResource(R.drawable.ghost)
                        resist2.setBackgroundResource(R.drawable.circle_ghost)
                    }
                    "steel" -> {
                        resist2.setImageResource(R.drawable.iron)
                        resist2.setBackgroundResource(R.drawable.circle_iron)
                    }
                    "normal" -> {
                        resist2.setImageResource(R.drawable.normal)
                        resist2.setBackgroundResource(R.drawable.circle_normal)
                    }
                }
                when (damage[0].name5) {
                    "fire" -> {
                        resist3.setImageResource(R.drawable.fire)
                        resist3.setBackgroundResource(R.drawable.circle_fire)
                    }
                    "water" -> {
                        resist3.setImageResource(R.drawable.water)
                        resist3.setBackgroundResource(R.drawable.circle_water)
                    }
                    "ice" -> {
                        resist3.setImageResource(R.drawable.ice)
                        resist3.setBackgroundResource(R.drawable.circle_ice)
                    }
                    "grass" -> {
                        resist3.setImageResource(R.drawable.grass)
                        resist3.setBackgroundResource(R.drawable.circle_grass)
                    }
                    "poison" -> {
                        resist3.setImageResource(R.drawable.poison)
                        resist3.setBackgroundResource(R.drawable.circle_poison)
                    }
                    "fighting" -> {
                        resist3.setImageResource(R.drawable.fighting)
                        resist3.setBackgroundResource(R.drawable.circle_fighting)
                    }
                    "rock" -> {
                        resist3.setImageResource(R.drawable.rock)
                        resist3.setBackgroundResource(R.drawable.circle_rock)
                    }
                    "flying" -> {
                        resist3.setImageResource(R.drawable.flying)
                        resist3.setBackgroundResource(R.drawable.circle_flying)
                    }
                    "dragon" -> {
                        resist3.setImageResource(R.drawable.dragon)
                        resist3.setBackgroundResource(R.drawable.circle_dragon)
                    }
                    "electric" -> {
                        resist3.setImageResource(R.drawable.electric)
                        resist3.setBackgroundResource(R.drawable.circle_electric)
                    }
                    "bug" -> {
                        resist3.setImageResource(R.drawable.bug)
                        resist3.setBackgroundResource(R.drawable.circle_bug)
                    }
                    "psychic" -> {
                        resist3.setImageResource(R.drawable.psychic)
                        resist3.setBackgroundResource(R.drawable.circle_psychic)
                    }
                    "ground" -> {
                        resist3.setImageResource(R.drawable.ground)
                        resist3.setBackgroundResource(R.drawable.circle_ground)
                    }
                    "fairy" -> {
                        resist3.setImageResource(R.drawable.fairy)
                        resist3.setBackgroundResource(R.drawable.circle_fairy)
                    }
                    "dark" -> {
                        resist3.setImageResource(R.drawable.dark)
                        resist3.setBackgroundResource(R.drawable.circle_dark)
                    }
                    "ghost" -> {
                        resist3.setImageResource(R.drawable.ghost)
                        resist3.setBackgroundResource(R.drawable.circle_ghost)
                    }
                    "steel" -> {
                        resist3.setImageResource(R.drawable.iron)
                        resist3.setBackgroundResource(R.drawable.circle_iron)
                    }
                    "normal" -> {
                        resist3.setImageResource(R.drawable.normal)
                        resist3.setBackgroundResource(R.drawable.circle_normal)
                    }
                }
            }
        })
        getDamageType()
        damageViewModel.getDamage(damageType)
    }

    private fun getDamageType() {
        when (pokemonType) {
            "fire" -> damageType = 10
            "grass" -> damageType = 12
            "poison" -> damageType = 4
            "dragon" -> damageType = 16
            "flying" -> damageType = 3
            "ghost" -> damageType = 8
            "ground" -> damageType = 5
            "normal" -> damageType = 1
            "psychic" -> damageType = 14
            "fairy" -> damageType = 18
            "rock" -> damageType = 6
            "steel" -> damageType = 9
            "water" -> damageType = 11
            "dark" -> damageType = 11
            "bug" -> damageType = 7
            "electric" -> damageType = 13
            "fighting" -> damageType = 2
            "ice" -> damageType = 15
        }
    }

    override fun onStart() {
        super.onStart()
        initDamageRelations()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_stats, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(id: String, type: String) = StatsFragment().apply {
            arguments = Bundle().apply {
                putString("ID", "id")
                putString("TYPE", "type")
                value = id
                pokemonType = type
            }
        }
    }

    private fun initDamageRelations() {
        when (pokemonType) {
            "fire" -> {
                weakness1.setImageResource(R.drawable.fire)
                weakness1.setBackgroundResource(R.drawable.circle_fire)
                txtWeakness1.text = getString(R.string.Fire)
            }
            "water" -> {
                weakness1.setImageResource(R.drawable.water)
                weakness1.setBackgroundResource(R.drawable.circle_water)
                txtWeakness1.text = getString(R.string.Water)
            }
            "ice" -> {
                weakness1.setImageResource(R.drawable.ice)
                weakness1.setBackgroundResource(R.drawable.circle_ice)
                txtWeakness1.text = getString(R.string.Ice)
            }
            "grass" -> {
                weakness1.setImageResource(R.drawable.grass)
                weakness1.setBackgroundResource(R.drawable.circle_grass)
                txtWeakness1.text = getString(R.string.Grass)
            }
            "poison" -> {
                weakness1.setImageResource(R.drawable.poison)
                weakness1.setBackgroundResource(R.drawable.circle_poison)
                txtWeakness1.text = getString(R.string.Poison)
            }
            "fighting" -> {
                weakness1.setImageResource(R.drawable.fighting)
                weakness1.setBackgroundResource(R.drawable.circle_fighting)
                txtWeakness1.text = getString(R.string.Fighting)
            }
            "rock" -> {
                weakness1.setImageResource(R.drawable.rock)
                weakness1.setBackgroundResource(R.drawable.circle_rock)
                txtWeakness1.text = getString(R.string.Rock)
            }
            "flying" -> {
                weakness1.setImageResource(R.drawable.flying)
                weakness1.setBackgroundResource(R.drawable.circle_flying)
                txtWeakness1.text = getString(R.string.Flying)
            }
            "dragon" -> {
                weakness1.setImageResource(R.drawable.dragon)
                weakness1.setBackgroundResource(R.drawable.circle_dragon)
                txtWeakness1.text = getString(R.string.Dragon)
            }
            "electric" -> {
                weakness1.setImageResource(R.drawable.electric)
                weakness1.setBackgroundResource(R.drawable.circle_electric)
                txtWeakness1.text = getString(R.string.Electric)
            }
            "bug" -> {
                weakness1.setImageResource(R.drawable.bug)
                weakness1.setBackgroundResource(R.drawable.circle_bug)
                txtWeakness1.text = getString(R.string.Bug)
            }
            "psychic" -> {
                weakness1.setImageResource(R.drawable.psychic)
                weakness1.setBackgroundResource(R.drawable.circle_psychic)
                txtWeakness1.text = getString(R.string.Psychic)
            }
            "ground" -> {
                weakness1.setImageResource(R.drawable.ground)
                weakness1.setBackgroundResource(R.drawable.circle_ground)
                txtWeakness1.text = getString(R.string.Ground)
            }
            "fairy" -> {
                weakness1.setImageResource(R.drawable.fairy)
                weakness1.setBackgroundResource(R.drawable.circle_fairy)
                txtWeakness1.text = getString(R.string.Fairy)
            }
            "dark" -> {
                weakness1.setImageResource(R.drawable.dark)
                weakness1.setBackgroundResource(R.drawable.circle_dark)
                txtWeakness1.text = getString(R.string.Dark)
            }
            "ghost" -> {
                weakness1.setImageResource(R.drawable.ghost)
                weakness1.setBackgroundResource(R.drawable.circle_ghost)
                txtWeakness1.text = getString(R.string.Ghost)
            }
            "steel" -> {
                weakness1.setImageResource(R.drawable.iron)
                weakness1.setBackgroundResource(R.drawable.circle_iron)
                txtWeakness1.text = getString(R.string.Steel)
            }
            "normal" -> {
                weakness1.setImageResource(R.drawable.normal)
                weakness1.setBackgroundResource(R.drawable.circle_normal)
                txtWeakness1.text = getString(R.string.Normal)
            }
        }
        when (pokemonType) {
            "fire" -> {
                weakness2.setImageResource(R.drawable.fire)
                weakness2.setBackgroundResource(R.drawable.circle_fire)
                txtWeakness2.text = getString(R.string.Fire)
            }
            "water" -> {
                weakness2.setImageResource(R.drawable.water)
                weakness2.setBackgroundResource(R.drawable.circle_water)
                txtWeakness2.text = getString(R.string.Water)
            }
            "ice" -> {
                weakness2.setImageResource(R.drawable.ice)
                weakness2.setBackgroundResource(R.drawable.circle_ice)
                txtWeakness2.text = getString(R.string.Ice)
            }
            "grass" -> {
                weakness2.setImageResource(R.drawable.grass)
                weakness2.setBackgroundResource(R.drawable.circle_grass)
                txtWeakness2.text = getString(R.string.Grass)
            }
            "poison" -> {
                weakness2.setImageResource(R.drawable.poison)
                weakness2.setBackgroundResource(R.drawable.circle_poison)
                txtWeakness2.text = getString(R.string.Poison)
            }
            "fighting" -> {
                weakness2.setImageResource(R.drawable.fighting)
                weakness2.setBackgroundResource(R.drawable.circle_fighting)
                txtWeakness2.text = getString(R.string.Fighting)
            }
            "rock" -> {
                weakness2.setImageResource(R.drawable.rock)
                weakness2.setBackgroundResource(R.drawable.circle_rock)
                txtWeakness2.text = getString(R.string.Rock)
            }
            "flying" -> {
                weakness2.setImageResource(R.drawable.flying)
                weakness2.setBackgroundResource(R.drawable.circle_flying)
                txtWeakness2.text = getString(R.string.Flying)
            }
            "dragon" -> {
                weakness2.setImageResource(R.drawable.dragon)
                weakness2.setBackgroundResource(R.drawable.circle_dragon)
                txtWeakness2.text = getString(R.string.Dragon)
            }
            "electric" -> {
                weakness2.setImageResource(R.drawable.electric)
                weakness2.setBackgroundResource(R.drawable.circle_electric)
                txtWeakness2.text = getString(R.string.Electric)
            }
            "bug" -> {
                weakness2.setImageResource(R.drawable.bug)
                weakness2.setBackgroundResource(R.drawable.circle_bug)
                txtWeakness2.text = getString(R.string.Bug)
            }
            "psychic" -> {
                weakness2.setImageResource(R.drawable.psychic)
                weakness2.setBackgroundResource(R.drawable.circle_psychic)
                txtWeakness2.text = getString(R.string.Psychic)
            }
            "ground" -> {
                weakness2.setImageResource(R.drawable.ground)
                weakness2.setBackgroundResource(R.drawable.circle_ground)
                txtWeakness2.text = getString(R.string.Ground)
            }
            "fairy" -> {
                weakness2.setImageResource(R.drawable.fairy)
                weakness2.setBackgroundResource(R.drawable.circle_fairy)
                txtWeakness2.text = getString(R.string.Fairy)
            }
            "dark" -> {
                weakness2.setImageResource(R.drawable.dark)
                weakness2.setBackgroundResource(R.drawable.circle_dark)
                txtWeakness2.text = getString(R.string.Dark)
            }
            "ghost" -> {
                weakness2.setImageResource(R.drawable.ghost)
                weakness2.setBackgroundResource(R.drawable.circle_ghost)
                txtWeakness2.text = getString(R.string.Ghost)
            }
            "steel" -> {
                weakness2.setImageResource(R.drawable.iron)
                weakness2.setBackgroundResource(R.drawable.circle_iron)
                txtWeakness2.text = getString(R.string.Steel)
            }
            "normal" -> {
                weakness2.setImageResource(R.drawable.normal)
                weakness2.setBackgroundResource(R.drawable.circle_normal)
                txtWeakness2.text = getString(R.string.Normal)
            }
        }
        when (pokemonType) {
            "fire" -> {
                weakness3.setImageResource(R.drawable.fire)
                weakness3.setBackgroundResource(R.drawable.circle_fire)
                txtWeakness3.text = getString(R.string.Fire)
            }
            "water" -> {
                weakness3.setImageResource(R.drawable.water)
                weakness3.setBackgroundResource(R.drawable.circle_water)
                txtWeakness3.text = getString(R.string.Water)
            }
            "ice" -> {
                weakness3.setImageResource(R.drawable.ice)
                weakness3.setBackgroundResource(R.drawable.circle_ice)
                txtWeakness3.text = getString(R.string.Ice)
            }
            "grass" -> {
                weakness3.setImageResource(R.drawable.grass)
                weakness3.setBackgroundResource(R.drawable.circle_grass)
                txtWeakness3.text = getString(R.string.Grass)
            }
            "poison" -> {
                weakness3.setImageResource(R.drawable.poison)
                weakness3.setBackgroundResource(R.drawable.circle_poison)
                txtWeakness3.text = getString(R.string.Poison)
            }
            "fighting" -> {
                weakness3.setImageResource(R.drawable.fighting)
                weakness3.setBackgroundResource(R.drawable.circle_fighting)
                txtWeakness3.text = getString(R.string.Fighting)
            }
            "rock" -> {
                weakness3.setImageResource(R.drawable.rock)
                weakness3.setBackgroundResource(R.drawable.circle_rock)
                txtWeakness3.text = getString(R.string.Rock)
            }
            "flying" -> {
                weakness3.setImageResource(R.drawable.flying)
                weakness3.setBackgroundResource(R.drawable.circle_flying)
                txtWeakness3.text = getString(R.string.Flying)
            }
            "dragon" -> {
                weakness3.setImageResource(R.drawable.dragon)
                weakness3.setBackgroundResource(R.drawable.circle_dragon)
                txtWeakness3.text = getString(R.string.Dragon)
            }
            "electric" -> {
                weakness3.setImageResource(R.drawable.electric)
                weakness3.setBackgroundResource(R.drawable.circle_electric)
                txtWeakness3.text = getString(R.string.Electric)
            }
            "bug" -> {
                weakness3.setImageResource(R.drawable.bug)
                weakness3.setBackgroundResource(R.drawable.circle_bug)
                txtWeakness3.text = getString(R.string.Bug)
            }
            "psychic" -> {
                weakness3.setImageResource(R.drawable.psychic)
                weakness3.setBackgroundResource(R.drawable.circle_psychic)
                txtWeakness3.text = getString(R.string.Psychic)
            }
            "ground" -> {
                weakness3.setImageResource(R.drawable.ground)
                weakness3.setBackgroundResource(R.drawable.circle_ground)
                txtWeakness3.text = getString(R.string.Grass)
            }
            "fairy" -> {
                weakness3.setImageResource(R.drawable.fairy)
                weakness3.setBackgroundResource(R.drawable.circle_fairy)
                txtWeakness3.text = getString(R.string.Fairy)
            }
            "dark" -> {
                weakness3.setImageResource(R.drawable.dark)
                weakness3.setBackgroundResource(R.drawable.circle_dark)
                txtWeakness3.text = getString(R.string.Dark)
            }
            "ghost" -> {
                weakness3.setImageResource(R.drawable.ghost)
                weakness3.setBackgroundResource(R.drawable.circle_ghost)
                txtWeakness3.text = getString(R.string.Ghost)
            }
            "steel" -> {
                weakness3.setImageResource(R.drawable.iron)
                weakness3.setBackgroundResource(R.drawable.circle_iron)
                txtWeakness3.text = getString(R.string.Steel)
            }
            "normal" -> {
                weakness3.setImageResource(R.drawable.normal)
                weakness3.setBackgroundResource(R.drawable.circle_normal)
                txtWeakness3.text = getString(R.string.Normal)
            }
        }
        when (pokemonType) {
            "fire" -> {
                resist1.setImageResource(R.drawable.fire)
                resist1.setBackgroundResource(R.drawable.circle_fire)
                txtResist1.text = getString(R.string.Fire)
            }
            "water" -> {
                resist1.setImageResource(R.drawable.water)
                resist1.setBackgroundResource(R.drawable.circle_water)
                txtResist1.text = getString(R.string.Water)
            }
            "ice" -> {
                resist1.setImageResource(R.drawable.ice)
                resist1.setBackgroundResource(R.drawable.circle_ice)
                txtResist1.text = getString(R.string.Ice)
            }
            "grass" -> {
                resist1.setImageResource(R.drawable.grass)
                resist1.setBackgroundResource(R.drawable.circle_grass)
                txtResist1.text = getString(R.string.Grass)
            }
            "poison" -> {
                resist1.setImageResource(R.drawable.poison)
                resist1.setBackgroundResource(R.drawable.circle_poison)
                txtResist1.text = getString(R.string.Poison)
            }
            "fighting" -> {
                resist1.setImageResource(R.drawable.fighting)
                resist1.setBackgroundResource(R.drawable.circle_fighting)
                txtResist1.text = getString(R.string.Fighting)
            }
            "rock" -> {
                resist1.setImageResource(R.drawable.rock)
                resist1.setBackgroundResource(R.drawable.circle_rock)
                txtResist1.text = getString(R.string.Rock)
            }
            "flying" -> {
                resist1.setImageResource(R.drawable.flying)
                resist1.setBackgroundResource(R.drawable.circle_flying)
                txtResist1.text = getString(R.string.Flying)
            }
            "dragon" -> {
                resist1.setImageResource(R.drawable.dragon)
                resist1.setBackgroundResource(R.drawable.circle_dragon)
                txtResist1.text = getString(R.string.Dragon)
            }
            "electric" -> {
                resist1.setImageResource(R.drawable.electric)
                resist1.setBackgroundResource(R.drawable.circle_electric)
                txtResist1.text = getString(R.string.Electric)
            }
            "bug" -> {
                resist1.setImageResource(R.drawable.bug)
                resist1.setBackgroundResource(R.drawable.circle_bug)
                txtResist1.text = getString(R.string.Bug)
            }
            "psychic" -> {
                resist1.setImageResource(R.drawable.psychic)
                resist1.setBackgroundResource(R.drawable.circle_psychic)
                txtResist1.text = getString(R.string.Psychic)
            }
            "ground" -> {
                resist1.setImageResource(R.drawable.ground)
                resist1.setBackgroundResource(R.drawable.circle_ground)
                txtResist1.text = getString(R.string.Ground)
            }
            "fairy" -> {
                resist1.setImageResource(R.drawable.fairy)
                resist1.setBackgroundResource(R.drawable.circle_fairy)
                txtResist1.text = getString(R.string.Fairy)
            }
            "dark" -> {
                resist1.setImageResource(R.drawable.dark)
                resist1.setBackgroundResource(R.drawable.circle_dark)
                txtResist1.text = getString(R.string.Dark)
            }
            "ghost" -> {
                resist1.setImageResource(R.drawable.ghost)
                resist1.setBackgroundResource(R.drawable.circle_ghost)
                txtResist1.text = getString(R.string.Ghost)
            }
            "steel" -> {
                resist1.setImageResource(R.drawable.iron)
                resist1.setBackgroundResource(R.drawable.circle_iron)
                txtResist1.text = getString(R.string.Steel)
            }
            "normal" -> {
                resist1.setImageResource(R.drawable.normal)
                resist1.setBackgroundResource(R.drawable.circle_normal)
                txtResist1.text = getString(R.string.Normal)
            }
        }
        when (pokemonType) {
            "fire" -> {
                resist2.setImageResource(R.drawable.fire)
                resist2.setBackgroundResource(R.drawable.circle_fire)
                txtResist2.text = getString(R.string.Fire)
            }
            "water" -> {
                resist2.setImageResource(R.drawable.water)
                resist2.setBackgroundResource(R.drawable.circle_water)
                txtResist2.text = getString(R.string.Water)
            }
            "ice" -> {
                resist2.setImageResource(R.drawable.ice)
                resist2.setBackgroundResource(R.drawable.circle_ice)
                txtResist2.text = getString(R.string.Ice)
            }
            "grass" -> {
                resist2.setImageResource(R.drawable.grass)
                resist2.setBackgroundResource(R.drawable.circle_grass)
                txtResist2.text = getString(R.string.Grass)
            }
            "poison" -> {
                resist2.setImageResource(R.drawable.poison)
                resist2.setBackgroundResource(R.drawable.circle_poison)
                txtResist2.text = getString(R.string.Poison)
            }
            "fighting" -> {
                resist2.setImageResource(R.drawable.fighting)
                resist2.setBackgroundResource(R.drawable.circle_fighting)
                txtResist2.text = getString(R.string.Fighting)
            }
            "rock" -> {
                resist2.setImageResource(R.drawable.rock)
                resist2.setBackgroundResource(R.drawable.circle_rock)
                txtResist2.text = getString(R.string.Rock)
            }
            "flying" -> {
                resist2.setImageResource(R.drawable.flying)
                resist2.setBackgroundResource(R.drawable.circle_flying)
                txtResist2.text = getString(R.string.Flying)
            }
            "dragon" -> {
                resist2.setImageResource(R.drawable.dragon)
                resist2.setBackgroundResource(R.drawable.circle_dragon)
                txtResist2.text = getString(R.string.Dragon)
            }
            "electric" -> {
                resist2.setImageResource(R.drawable.electric)
                resist2.setBackgroundResource(R.drawable.circle_electric)
                txtResist2.text = getString(R.string.Electric)
            }
            "bug" -> {
                resist2.setImageResource(R.drawable.bug)
                resist2.setBackgroundResource(R.drawable.circle_bug)
                txtResist2.text = getString(R.string.Bug)
            }
            "psychic" -> {
                resist2.setImageResource(R.drawable.psychic)
                resist2.setBackgroundResource(R.drawable.circle_psychic)
                txtResist2.text = getString(R.string.Psychic)
            }
            "ground" -> {
                resist2.setImageResource(R.drawable.ground)
                resist2.setBackgroundResource(R.drawable.circle_ground)
                txtResist2.text = getString(R.string.Ground)
            }
            "fairy" -> {
                resist2.setImageResource(R.drawable.fairy)
                resist2.setBackgroundResource(R.drawable.circle_fairy)
                txtResist2.text = getString(R.string.Fairy)
            }
            "dark" -> {
                resist2.setImageResource(R.drawable.dark)
                resist2.setBackgroundResource(R.drawable.circle_dark)
                txtResist2.text = getString(R.string.Dark)
            }
            "ghost" -> {
                resist2.setImageResource(R.drawable.ghost)
                resist2.setBackgroundResource(R.drawable.circle_ghost)
                txtResist2.text = getString(R.string.Ghost)
            }
            "steel" -> {
                resist2.setImageResource(R.drawable.iron)
                resist2.setBackgroundResource(R.drawable.circle_iron)
                txtResist2.text = getString(R.string.Steel)
            }
            "normal" -> {
                resist2.setImageResource(R.drawable.normal)
                resist2.setBackgroundResource(R.drawable.circle_normal)
                txtResist2.text = getString(R.string.Normal)
            }
        }
        when (pokemonType) {
            "fire" -> {
                resist3.setImageResource(R.drawable.fire)
                resist3.setBackgroundResource(R.drawable.circle_fire)
                txtResist3.text = getString(R.string.Fire)
            }
            "water" -> {
                resist3.setImageResource(R.drawable.water)
                resist3.setBackgroundResource(R.drawable.circle_water)
                txtResist3.text = getString(R.string.Water)
            }
            "ice" -> {
                resist3.setImageResource(R.drawable.ice)
                resist3.setBackgroundResource(R.drawable.circle_ice)
                txtResist3.text = getString(R.string.Ice)
            }
            "grass" -> {
                resist3.setImageResource(R.drawable.grass)
                resist3.setBackgroundResource(R.drawable.circle_grass)
                txtResist3.text = getString(R.string.Grass)
            }
            "poison" -> {
                resist3.setImageResource(R.drawable.poison)
                resist3.setBackgroundResource(R.drawable.circle_poison)
                txtResist3.text = getString(R.string.Poison)
            }
            "fighting" -> {
                resist3.setImageResource(R.drawable.fighting)
                resist3.setBackgroundResource(R.drawable.circle_fighting)
                txtResist3.text = getString(R.string.Fighting)
            }
            "rock" -> {
                resist3.setImageResource(R.drawable.rock)
                resist3.setBackgroundResource(R.drawable.circle_rock)
                txtResist3.text = getString(R.string.Rock)
            }
            "flying" -> {
                resist3.setImageResource(R.drawable.flying)
                resist3.setBackgroundResource(R.drawable.circle_flying)
                txtResist3.text = getString(R.string.Flying)
            }
            "dragon" -> {
                resist3.setImageResource(R.drawable.dragon)
                resist3.setBackgroundResource(R.drawable.circle_dragon)
                txtResist3.text = getString(R.string.Dragon)
            }
            "electric" -> {
                resist3.setImageResource(R.drawable.electric)
                resist3.setBackgroundResource(R.drawable.circle_electric)
                txtResist3.text = getString(R.string.Electric)
            }
            "bug" -> {
                resist3.setImageResource(R.drawable.bug)
                resist3.setBackgroundResource(R.drawable.circle_bug)
                txtResist3.text = getString(R.string.Bug)
            }
            "psychic" -> {
                resist3.setImageResource(R.drawable.psychic)
                resist3.setBackgroundResource(R.drawable.circle_psychic)
                txtResist3.text = getString(R.string.Psychic)
            }
            "ground" -> {
                resist3.setImageResource(R.drawable.ground)
                resist3.setBackgroundResource(R.drawable.circle_ground)
                txtResist3.text = getString(R.string.Ground)
            }
            "fairy" -> {
                resist3.setImageResource(R.drawable.fairy)
                resist3.setBackgroundResource(R.drawable.circle_fairy)
                txtResist3.text = getString(R.string.Fairy)
            }
            "dark" -> {
                resist3.setImageResource(R.drawable.dark)
                resist3.setBackgroundResource(R.drawable.circle_dark)
                txtResist3.text = getString(R.string.Dark)
            }
            "ghost" -> {
                resist3.setImageResource(R.drawable.ghost)
                resist3.setBackgroundResource(R.drawable.circle_ghost)
                txtResist3.text = getString(R.string.Ghost)
            }
            "steel" -> {
                resist3.setImageResource(R.drawable.iron)
                resist3.setBackgroundResource(R.drawable.circle_iron)
                txtResist3.text = getString(R.string.Steel)
            }
            "normal" -> {
                resist3.setImageResource(R.drawable.normal)
                resist3.setBackgroundResource(R.drawable.circle_normal)
                txtResist3.text = getString(R.string.Normal)
            }
        }

    }
}











