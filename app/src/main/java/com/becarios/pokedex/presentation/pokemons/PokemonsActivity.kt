package com.becarios.pokedex.presentation.pokemons

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.SearchView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.becarios.pokedex.R
import com.becarios.pokedex.presentation.details.PokemonsDetailsActivity
import kotlinx.android.synthetic.main.activity_pokemons.*
import kotlinx.android.synthetic.main.pokemon_recycler_item.*

class PokemonsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemons)
        backGroundColor()

        val viewModel: PokemonViewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)

        viewModel.mLiveData.observe(this, Observer {
            it?.let { pokemons ->
                with(recyclerView) {
                    layoutManager = GridLayoutManager(this@PokemonsActivity, 1)
                    setHasFixedSize(true)
                    adapter = PokemonAdapter(pokemons) { pokemon ->
                        val intent = PokemonsDetailsActivity.getStartInt(
                            this@PokemonsActivity,
                            pokemon.name
                        )
                        this@PokemonsActivity.startActivity(intent)
                    }
                }
            }
        })
        viewModel.getPokemon()

        viewModel._mLiveData.observe(this, Observer {
            it?.let { pokemons ->
                with(recyclerView) {
                    layoutManager = GridLayoutManager(this@PokemonsActivity, 1)
                    setHasFixedSize(true)
                    adapter = PokemonIdAdapter(pokemons) { pokemon ->
                        val intent = PokemonsDetailsActivity.getStartInt(
                            this@PokemonsActivity,
                            pokemon.name
                        )
                        this@PokemonsActivity.startActivity(intent)
                    }
                }
            }
        })

        searchHeader.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.getPokemonId(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if(newText != ""){
                    viewModel.getPokemonId(newText)
                }else
                    viewModel.getPokemon()
                return false
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun backGroundColor() {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        window.setBackgroundDrawableResource(R.drawable.splash_gradient_light)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
    }

    fun pokemonType() {
        pokemon_type_one.contentDescription = "Pokemon do tipo grama"
        pokemon_type_two.contentDescription = "e veneno"
    }
}