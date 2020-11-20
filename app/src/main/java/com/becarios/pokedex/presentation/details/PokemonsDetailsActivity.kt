package com.becarios.pokedex.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.becarios.pokedex.R
import com.becarios.pokedex.presentation.details.fragments.AbilitiesFragments
import com.becarios.pokedex.presentation.details.fragments.EvolutionFragment
import com.becarios.pokedex.presentation.details.fragments.StatsFragment
import com.becarios.pokedex.presentation.pokemons.EnumPoke
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_pokemons_details.*
import util.Constant
import java.util.*

var idData = String()
var typeData = String()

class PokemonsDetailsActivity : AppCompatActivity() {
    lateinit var pokemonType: EnumPoke
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemons_details)

        val name = intent.getStringExtra(EXTRA_NAME)
        val id = intent.getStringExtra(EXTRA_ID)
        val idInt: Int = id?.toInt() ?: intent.getIntExtra(EXTRA_ID)
        val type = intent.getStringExtra(TYPE)
        val image = spritePoke
        var urlType = String()
        tituloToolbar.text = name.toString().capitalize(Locale.ROOT)

        when {
            idInt < 10 -> {
                idPoke.text = ("#00${id}")
            }
            idInt in 10..99 -> {
                idPoke.text = ("#0${id}")
            }
            else -> idPoke.text = ("#${id}")
        }

        idPoke.contentDescription = ("Número na pokedéx:$id")
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
                        val fragLayout = EvolutionFragment.newInstance(idData, typeData)
                        initFragment(fragLayout)
                    }
                    2 -> {
                        val fragLayout = AbilitiesFragments.newInstance(idData, typeData)
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
            Constant.FIRE ->
                setViewPokemon(
                    EnumPoke.FIRE.color,
                    EnumPoke.FIRE.typeName,
                    EnumPoke.FIRE.fundoDrawable,
                    EnumPoke.FIRE.typeDrawable
                )
            Constant.WATER -> setViewPokemon(
                EnumPoke.WATER.color,
                EnumPoke.WATER.typeName,
                EnumPoke.WATER.fundoDrawable,
                EnumPoke.WATER.typeDrawable
            )
            Constant.ICE -> setViewPokemon(
                EnumPoke.ICE.color,
                EnumPoke.ICE.typeName,
                EnumPoke.ICE.fundoDrawable,
                EnumPoke.ICE.typeDrawable
            )
            Constant.GRASS -> setViewPokemon(
                EnumPoke.GRASS.color,
                EnumPoke.GRASS.typeName,
                EnumPoke.GRASS.fundoDrawable,
                EnumPoke.GRASS.typeDrawable
            )
            Constant.POISON -> setViewPokemon(
                EnumPoke.POISON.color,
                EnumPoke.POISON.typeName,
                EnumPoke.POISON.fundoDrawable,
                EnumPoke.POISON.typeDrawable
            )
            Constant.FIGHTING -> setViewPokemon(
                EnumPoke.FIGHTING.color,
                EnumPoke.FIGHTING.typeName,
                EnumPoke.FIGHTING.fundoDrawable,
                EnumPoke.FIGHTING.typeDrawable
            )
            Constant.ROCK -> setViewPokemon(
                EnumPoke.ROCK.color,
                EnumPoke.ROCK.typeName,
                EnumPoke.ROCK.fundoDrawable,
                EnumPoke.ROCK.typeDrawable
            )
            Constant.FLYING -> setViewPokemon(
                EnumPoke.FLYING.color,
                EnumPoke.FLYING.typeName,
                EnumPoke.FLYING.fundoDrawable,
                EnumPoke.FLYING.typeDrawable
            )
            Constant.ELECTRIC -> setViewPokemon(
                EnumPoke.ELECTRIC.color,
                EnumPoke.ELECTRIC.typeName,
                EnumPoke.ELECTRIC.fundoDrawable,
                EnumPoke.ELECTRIC.typeDrawable
            )
            Constant.DRAGON -> setViewPokemon(
                EnumPoke.DRAGON.color,
                EnumPoke.DRAGON.typeName,
                EnumPoke.DRAGON.fundoDrawable,
                EnumPoke.DRAGON.typeDrawable
            )
            Constant.BUG -> setViewPokemon(
                EnumPoke.BUG.color,
                EnumPoke.BUG.typeName,
                EnumPoke.BUG.fundoDrawable,
                EnumPoke.BUG.typeDrawable
            )
            Constant.PSYCHIC -> setViewPokemon(
                EnumPoke.PSYCHIC.color,
                EnumPoke.PSYCHIC.typeName,
                EnumPoke.PSYCHIC.fundoDrawable,
                EnumPoke.PSYCHIC.typeDrawable
            )
            Constant.GROUND -> setViewPokemon(
                EnumPoke.GROUND.color,
                EnumPoke.GROUND.typeName,
                EnumPoke.GROUND.fundoDrawable,
                EnumPoke.GROUND.typeDrawable
            )
            Constant.FAIRY -> setViewPokemon(
                EnumPoke.FAIRY.color,
                EnumPoke.FAIRY.typeName,
                EnumPoke.FAIRY.fundoDrawable,
                EnumPoke.FAIRY.typeDrawable
            )
            Constant.DARK -> setViewPokemon(
                EnumPoke.DARK.color,
                EnumPoke.DARK.typeName,
                EnumPoke.DARK.fundoDrawable,
                EnumPoke.DARK.typeDrawable
            )
            Constant.GHOST -> setViewPokemon(
                EnumPoke.GHOST.color,
                EnumPoke.GHOST.typeName,
                EnumPoke.GHOST.fundoDrawable,
                EnumPoke.GHOST.typeDrawable
            )
            Constant.STEEL -> setViewPokemon(
                EnumPoke.STEEL.color,
                EnumPoke.STEEL.typeName,
                EnumPoke.STEEL.fundoDrawable,
                EnumPoke.STEEL.typeDrawable
            )
            Constant.NORMAL -> setViewPokemon(
                EnumPoke.NORMAL.color,
                EnumPoke.NORMAL.typeName,
                EnumPoke.NORMAL.fundoDrawable,
                EnumPoke.NORMAL.typeDrawable
            )
        }

        Glide.with(spritePoke)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${id}.png")
            .error(R.drawable.pokeboll)
            .centerCrop()
            .into(image)
    }

    fun setViewPokemon(color: Int, typeName: String, fundoPoke: Int, typeDrawable: Int) {
        typePoke.setCompoundDrawablesWithIntrinsicBounds(typeDrawable, 0, 0, 0)
        typePoke.contentDescription = "Pokemon do tipo $typeName"
        typePoke.setBackgroundResource(fundoPoke)
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, color))
        tabLayout.setTabTextColors(
            ContextCompat.getColor(this, color),
            ContextCompat.getColor(this, R.color.whiteColor)
        )
        motionLayout.setBackgroundColor(ContextCompat.getColor(this, color))

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
private fun Intent.getIntExtra(extraId: String): Int {
    return extraId.toInt()
}
