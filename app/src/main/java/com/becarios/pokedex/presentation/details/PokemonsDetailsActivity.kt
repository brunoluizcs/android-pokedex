package com.becarios.pokedex.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.becarios.pokedex.R
import com.becarios.pokedex.data.model.PokemonsStats
import com.becarios.pokedex.presentation.details.fragments.StatsAdapter
import com.becarios.pokedex.presentation.details.fragments.StatsFragment
import com.becarios.pokedex.presentation.details.fragments.StatsViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_pokemons.*
import kotlinx.android.synthetic.main.activity_pokemons_details.*

var idDataSend = String()
class PokemonsDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemons_details)

        val name = intent.getStringExtra(EXTRA_NAME)
        val id = intent.getStringExtra(EXTRA_ID)
        val type = intent.getStringExtra(TYPE)
        val image = spritePoke
        tituloToolbar.text = name
        idPoke.text = ("#$id")
        typePoke.text = type

      /*  val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frameLayout, StatsFragment())
        ft.commit()*/
        initFragment()


        when (type) {
            "fire" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_fire)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.fire))
                tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.fire), ContextCompat.getColor(this, R.color.whiteColor))
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.fire))
            }
            "water" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_water)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.water))
                tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.water), ContextCompat.getColor(this, R.color.whiteColor))
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.water))
            }
            "ice" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_ice)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.ice))
                tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.ice), ContextCompat.getColor(this, R.color.whiteColor))
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.ice))
            }
            "grass" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_grass)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.grass))
                tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.grass), ContextCompat.getColor(this, R.color.whiteColor))
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.grass))
            }
            "poison" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_poison)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.poison))
                tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.poison), ContextCompat.getColor(this, R.color.whiteColor))
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.poison))
            }
            "fighting" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_fight)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.fight))
                tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.fight), ContextCompat.getColor(this, R.color.whiteColor))
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.fight))
            }
            "rock" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_rock)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.rock))
                tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.rock), ContextCompat.getColor(this, R.color.whiteColor))
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.rock))
            }
            "flying" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_flying)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.flying))
                tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.flying), ContextCompat.getColor(this, R.color.whiteColor))
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.flying))
            }
            "electric" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_electric)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.electric))
                tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.electric), ContextCompat.getColor(this, R.color.whiteColor))
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.electric))
            }
            "bug" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_bug)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.bug))
                tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.bug), ContextCompat.getColor(this, R.color.whiteColor))
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.bug))
            }
            "psychic" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_psychic)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.psychic))
                tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.psychic), ContextCompat.getColor(this, R.color.whiteColor))
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.psychic))
            }
            "ground" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_ground)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.ground))
                tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.ground), ContextCompat.getColor(this, R.color.whiteColor))
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.ground))
            }
            "fairy" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_fairy)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.fairy))
                tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.fairy), ContextCompat.getColor(this, R.color.whiteColor))
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.fairy))
            }
            "dark" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_dark)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.dark))
                tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.dark), ContextCompat.getColor(this, R.color.whiteColor))
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.dark))
            }
            "ghost" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_ghost)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.ghost))
                tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.ghost), ContextCompat.getColor(this, R.color.whiteColor))
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.ghost))
            }
            "steel" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_steel)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.steel))
                tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.steel), ContextCompat.getColor(this, R.color.whiteColor))
                motionLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.steel))
            }
            "normal" -> {
                typePoke.setBackgroundResource(R.drawable.fundo_normal)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.normal))
                tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.normal), ContextCompat.getColor(this, R.color.whiteColor))
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
                idDataSend = id
            }
        }
    }

    private fun initFragment(){
        val fragment = StatsFragment.newInstance(idDataSend)
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frameLayout, fragment)
        ft.commit()
    }
}