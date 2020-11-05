package com.becarios.pokedex.presentation.pokemons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.becarios.pokedex.R
import com.becarios.pokedex.data.model.Pokemons
import com.becarios.pokedex.data.model.PokemonsId
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.pokemon_recycler_item.view.*

class PokemonIdAdapter (
    private val pokemons: List<PokemonsId>,
    val onItemClickListener: ((pokemon: PokemonsId) -> Unit)
) :
    RecyclerView.Adapter<PokemonIdAdapter.PokemonsViewHolder>() {
    val pokemonsCount = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_recycler_item, parent, false)
        return PokemonsViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(viewholder: PokemonsViewHolder, position: Int) {
        viewholder.bindView(pokemons[position])
    }

    override fun getItemCount() = pokemonsCount

    class PokemonsViewHolder(
        itemView: View,
        private val onItemClickListener: ((pokemon: PokemonsId) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.txt_pokemon_name
        private val id = itemView.txt_pokemon_id

        private val image = itemView.imagePokemon

        fun bindView(pokemon: PokemonsId) {

            name.text = pokemon.name
            id.text = pokemon.id
            val id = pokemon.id


            Glide.with(itemView)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${id}.png")
                .error(R.drawable.pokeboll)
                .centerCrop()
                .into(image)


            itemView.setOnClickListener {
                onItemClickListener.invoke(pokemon)
            }
        }
    }
}
