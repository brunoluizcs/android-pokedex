package com.becarios.pokedex.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.becarios.pokedex.R

class PokemonsDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemons_details)

        val name = intent.getStringExtra(EXTRA_NAME)
    }

    companion object {
        private const val EXTRA_NAME = "EXTRA_NAME"

        fun getStartInt(context: Context, name: String): Intent {
            return Intent(context, PokemonsDetailsActivity::class.java).apply {
                putExtra(EXTRA_NAME, name)
            }
        }
    }
}