package com.becarios.pokedex.presentation.pokemons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.becarios.pokedex.R
import com.becarios.pokedex.presentation.details.PokemonsDetailsActivity
import com.becarios.pokedex.presentation.details.fragments.StatsFragment
import kotlinx.android.synthetic.main.activity_pokemons.*

class PokemonsActivity : AppCompatActivity() {

    lateinit var layoutManager: LinearLayoutManager
    var loading = false
    var limit = 20
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutManager = LinearLayoutManager(this)
        setContentView(R.layout.activity_pokemons)
        val viewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)


        viewModel.mLiveData.observe(this, Observer {
            it?.let { pokemons ->
                with(recyclerView) {
                    layoutManager = GridLayoutManager(this@PokemonsActivity, 1)
                    setHasFixedSize(true)
                    adapter = PokemonAdapter(pokemons) { pokemon ->
                       val intent = PokemonsDetailsActivity.getStartInt(
                            this@PokemonsActivity,
                            pokemon.name,
                            pokemon.id,
                            pokemon.typeName1
                        )
                        this@PokemonsActivity.startActivity(intent)
                    }

                    addOnScrollListener(object : RecyclerView.OnScrollListener() {
                        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                            if (dy > 0) {
                                var visibleItemCount =
                                    (layoutManager as GridLayoutManager).childCount
                                var pastVisibleItem =
                                    (layoutManager as GridLayoutManager).findFirstCompletelyVisibleItemPosition()
                                val total2 = visibleItemCount + pastVisibleItem

                                if (!loading && (total2) >= pokemons.size) {

                                    loading = true
                                    limit += 11
                                    viewModel.getPokemonPage(limit)
                                    progressBar.visibility = (View.VISIBLE)
                                    Handler(Looper.getMainLooper()).postDelayed({
                                        viewModel.mLiveData.observe(this@PokemonsActivity, Observer {
                                            it?.let { pokemons ->
                                                with(recyclerView) {
                                                    adapter?.notifyItemInserted(pokemons.lastIndex)
                                                }
                                            }
                                            progressBar.visibility = (View.GONE)
                                            loading = false
                                        })

                                    },500)
                                }
                            }

                            super.onScrolled(recyclerView, dx, dy)
                        }
                    })
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
                            pokemon.name,
                            pokemon.id,
                            pokemon.typeName1
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

}