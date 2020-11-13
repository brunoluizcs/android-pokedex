package com.becarios.pokedex.presentation.pokemons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.becarios.pokedex.R
import com.becarios.pokedex.presentation.details.fragments.StatsFragment

class PokemonsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemons_details)

        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frameLayout, StatsFragment())
        ft.commit()

    }
}