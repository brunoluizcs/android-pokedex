package com.becarios.pokedex.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.widget.Button
import android.widget.TableLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.becarios.pokedex.R
import com.becarios.pokedex.presentation.details.fragments.AbilitiesFragments
import com.becarios.pokedex.presentation.details.fragments.EvolutionFragment
import com.becarios.pokedex.presentation.details.fragments.StatsFragment
import com.becarios.pokedex.presentation.pokemons.PokemonType
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_pokemons_details.*
import java.util.*

var idData = String()
var typeData = String()

class PokemonsDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemons_details)

        val name = intent.getStringExtra(EXTRA_NAME)
        val id = intent.getStringExtra(EXTRA_ID)
        val type = intent.getStringExtra(TYPE)
        val image = spritePoke
        var urlType = String()
        tituloToolbar.text = name.toString().capitalize(Locale.ROOT)
        idPoke.text = ("#$id")
        typePoke.text = type


        backButton.setOnClickListener {
            if (motionLayout.currentState == motionLayout.endState) {
                motionLayout.transitionToStart()
            } else finish()
        }

        fun initFragment(fragLayout: Fragment) {
            val ft1: FragmentTransaction = supportFragmentManager.beginTransaction()
            ft1.replace(R.id.frameLayout, fragLayout)
            ft1.commit()
        }

        initFragment(fragLayout = StatsFragment.newInstance(idData, typeData))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
                        val fragLayout = StatsFragment.newInstance(idData, typeData)
                        initFragment(fragLayout)
                    }
                    1 -> {
                        val fragLayout = AbilitiesFragments.newInstance(idData, typeData)
                        initFragment(fragLayout)
                    }
                    2 -> {
                        val fragLayout = EvolutionFragment.newInstance(idData, typeData)
                        initFragment(fragLayout)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        when (type) {
            "fire" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_fire)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.fire))
                tabLayout.setTabTextColors(
                    ContextCompat.getColor(this, R.color.fire),
                    ContextCompat.getColor(this, R.color.whiteColor)
                )
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.fire))
            }
            "water" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_water)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.water))
                tabLayout.setTabTextColors(
                    ContextCompat.getColor(this, R.color.water),
                    ContextCompat.getColor(this, R.color.whiteColor)
                )
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.water))
            }
            "ice" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_ice)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.ice))
                tabLayout.setTabTextColors(
                    ContextCompat.getColor(this, R.color.ice),
                    ContextCompat.getColor(this, R.color.whiteColor)
                )
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.ice))
            }
            "grass" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_grass)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.grass))
                tabLayout.setTabTextColors(
                    ContextCompat.getColor(this, R.color.grass),
                    ContextCompat.getColor(this, R.color.whiteColor)
                )
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.grass))
            }
            "poison" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_poison)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.poison))
                tabLayout.setTabTextColors(
                    ContextCompat.getColor(this, R.color.poison),
                    ContextCompat.getColor(this, R.color.whiteColor)
                )
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.poison))
            }
            "fighting" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_fight)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.fight))
                tabLayout.setTabTextColors(
                    ContextCompat.getColor(this, R.color.fight),
                    ContextCompat.getColor(this, R.color.whiteColor)
                )
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.fight))
            }
            "rock" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_rock)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.rock))
                tabLayout.setTabTextColors(
                    ContextCompat.getColor(this, R.color.rock),
                    ContextCompat.getColor(this, R.color.whiteColor)
                )
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.rock))
            }
            "flying" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_flying)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.flying))
                tabLayout.setTabTextColors(
                    ContextCompat.getColor(this, R.color.flying),
                    ContextCompat.getColor(this, R.color.whiteColor)
                )
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.flying))
            }
            "electric" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_electric)
                tabLayout.setSelectedTabIndicatorColor(
                    ContextCompat.getColor(
                        this,
                        R.color.electric
                    )
                )
                tabLayout.setTabTextColors(
                    ContextCompat.getColor(this, R.color.electric),
                    ContextCompat.getColor(this, R.color.whiteColor)
                )
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.electric))
            }
            "bug" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_bug)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.bug))
                tabLayout.setTabTextColors(
                    ContextCompat.getColor(this, R.color.bug),
                    ContextCompat.getColor(this, R.color.whiteColor)
                )
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.bug))
            }
            "psychic" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_psychic)
                tabLayout.setSelectedTabIndicatorColor(
                    ContextCompat.getColor(
                        this,
                        R.color.psychic
                    )
                )
                tabLayout.setTabTextColors(
                    ContextCompat.getColor(this, R.color.psychic),
                    ContextCompat.getColor(this, R.color.whiteColor)
                )
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.psychic))
            }
            "ground" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_ground)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.ground))
                tabLayout.setTabTextColors(
                    ContextCompat.getColor(this, R.color.ground),
                    ContextCompat.getColor(this, R.color.whiteColor)
                )
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.ground))
            }
            "fairy" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_fairy)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.fairy))
                tabLayout.setTabTextColors(
                    ContextCompat.getColor(this, R.color.fairy),
                    ContextCompat.getColor(this, R.color.whiteColor)
                )
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.fairy))
            }
            "dark" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_dark)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.dark))
                tabLayout.setTabTextColors(
                    ContextCompat.getColor(this, R.color.dark),
                    ContextCompat.getColor(this, R.color.whiteColor)
                )
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.dark))
            }
            "ghost" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_ghost)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.ghost))
                tabLayout.setTabTextColors(
                    ContextCompat.getColor(this, R.color.ghost),
                    ContextCompat.getColor(this, R.color.whiteColor)
                )
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.ghost))
            }
            "steel" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_steel)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.steel))
                tabLayout.setTabTextColors(
                    ContextCompat.getColor(this, R.color.steel),
                    ContextCompat.getColor(this, R.color.whiteColor)
                )
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.steel))
            }
            "normal" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_normal)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.normal))
                tabLayout.setTabTextColors(
                    ContextCompat.getColor(this, R.color.normal),
                    ContextCompat.getColor(this, R.color.whiteColor)
                )
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.normal))
            }
        }

        Glide.with(spritePoke)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${id}.png")
            .error(R.drawable.pokeboll)
            .centerCrop()
            .into(image)
    }

    companion object {
        private const val EXTRA_NAME = "EXTRA_NAME"
        private const val EXTRA_ID = "EXTRA_ID"
        private const val TYPE = "type"

        fun getStartInt(context: Context, name: String, id: String, type: String): Intent {
            return Intent(context, PokemonsDetailsActivity::class.java).apply {
                putExtra(EXTRA_NAME, name)
                putExtra(EXTRA_ID, id)
                putExtra(TYPE, type)
                idData = id
                typeData = type
            }
        }
    }

}


