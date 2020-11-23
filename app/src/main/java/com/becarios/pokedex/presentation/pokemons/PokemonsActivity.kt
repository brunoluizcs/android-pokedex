package com.becarios.pokedex.presentation.pokemons

import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.becarios.pokedex.R
import com.becarios.pokedex.presentation.about.AboutActivity
import com.becarios.pokedex.presentation.details.PokemonsDetailsActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_pokemons.*

class PokemonsActivity : AppCompatActivity() {

    lateinit var layoutManager: LinearLayoutManager
    val viewModelFactory = PokemonViewModelFactory()
    val viewModel: PokemonViewModel by lazy { ViewModelProvider(this, viewModelFactory).get(PokemonViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
        layoutManager = LinearLayoutManager(this)
        setContentView(R.layout.activity_pokemons)
        val firebaseAnalytics = Firebase.analytics

        viewModel.mLiveData.observe(this, Observer {
            it?.let { pokemons -> with(recyclerView) {
                    layoutManager = GridLayoutManager(this@PokemonsActivity, 1)
                    setHasFixedSize(true)
                    adapter = PokemonAdapter(pokemons) { pokemon ->
                        val intent = PokemonsDetailsActivity.getStartInt(
                            this@PokemonsActivity,
                            pokemon.name, pokemon.id, pokemon.typeName1
                        )
                        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM){
                            param(FirebaseAnalytics.Param.ITEM_NAME, pokemon.name)
                            param(FirebaseAnalytics.Param.ITEM_ID, pokemon.id)
                            param(FirebaseAnalytics.Param.CONTENT_TYPE, pokemon.typeName1)
                        }
                        adapter?.notifyDataSetChanged()
                        this@PokemonsActivity.startActivity(intent)
                    }
                }
            }
        })
        viewModel.getPokemons()

        viewModel._mLiveData.observe(this, Observer {
            it?.let { pokemons -> with(recyclerView) {
                    layoutManager = GridLayoutManager(this@PokemonsActivity, 1)
                    setHasFixedSize(true)
                    adapter = PokemonIdAdapter(pokemons) { pokemon ->
                        val intent = PokemonsDetailsActivity.getStartInt(
                            this@PokemonsActivity,
                            pokemon.name, pokemon.id, pokemon.typeName1
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
                if (newText != "") { viewModel.getPokemonId(newText)
                } else viewModel.getPokemons()
                return false
            }
        })

        infoButtonHeader.setOnClickListener{
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }
}