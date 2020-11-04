package com.becarios.pokedex.presentation.pokemons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.becarios.pokedex.R
import com.becarios.pokedex.data.model.Pokemons
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.pokemon_recycler_item.view.*

class PokemonAdapter (
    private val pokemons: List<Pokemons>,
    val onItemClickListener: ((pokemon: Pokemons) -> Unit)
) :
    RecyclerView.Adapter<PokemonAdapter.PokemonsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_recycler_item, parent, false)
        return PokemonsViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(viewholder: PokemonsViewHolder, position: Int) {
        viewholder.bindView(pokemons[position])
    }

    override fun getItemCount() = pokemons.count()

    class PokemonsViewHolder(
        itemView: View,
        private val onItemClickListener: ((pokemon: Pokemons) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.txt_pokemon_name
        private val url = itemView.txt_pokemon_id

        private val id = itemView.txt_pokemon_id
        private val image = itemView.imagePokemon

        fun bindView(pokemon: Pokemons) {
            val string = pokemon.url
            val stringSplit = string.split("/").map { it.trim() }


            name.text = pokemon.name
            val id = stringSplit[6]
            url.text = ("#${id}")


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
