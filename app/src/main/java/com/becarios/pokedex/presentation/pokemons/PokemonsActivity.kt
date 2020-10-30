package com.becarios.pokedex.presentation.pokemons

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.becarios.pokedex.R
import kotlinx.android.synthetic.main.pokemon_recycler_item.*

class PokemonsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon_recycler_item)
        pokemonType()
    }

    fun pokemonType(){
        pokemon_type_one.contentDescription = "Pokemon do tipo grama"
        pokemon_type_two.contentDescription = "e veneno"
    }
}