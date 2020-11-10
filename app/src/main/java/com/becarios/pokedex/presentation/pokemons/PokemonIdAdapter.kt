package com.becarios.pokedex.presentation.pokemons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.becarios.pokedex.R
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


            if (pokemon.typeName1 == pokemon.typeName2)
                itemView.pokemon_type_two.visibility = View.GONE

            when (pokemon.typeName1) {
                "fire" -> {
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.fire)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_fire)
                }
                "water" -> {
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.water)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_water)
                }
                "ice" -> {
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.ice)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_water)
                }
                "grass" -> {
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.grass)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_grass)
                }
                "poison" -> {
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.poison)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_poison)
                }
                "fighting" -> {
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.fighting)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_fighting)
                }
                "rock" -> {
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.rock)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_rock)
                }
                "flying" -> {
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.flying)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_flying)
                }
                "electric" -> {
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.electric)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_electric)
                }
                "bug" -> {
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.bug)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_bug)
                }
                "psychic" -> {
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.psychic)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_psychic)
                }
                "ground" -> {
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.ground)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_ground)
                }
                "fairy" -> {
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.fairy)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_flying)
                }
                "dark" -> {
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.dark)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_dark)
                }
                "normal" -> {
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.normal)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_flying)
                }
                else -> {
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.pokeboll)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_normal)
                }
            }

            if (pokemon.typeName2 == pokemon.typeName1)
                itemView.pokemon_type_one.visibility = View.GONE

            when (pokemon.typeName2) {
                "fire" -> {
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.fire)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_fire)
                }
                "water" -> {
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.water)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_water)
                }
                "ice" -> {
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.ice)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_water)
                }
                "grass" -> {
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.grass)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_grass)
                }
                "poison" -> {
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.poison)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_poison)
                }
                "fighting" -> {
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.fighting)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_fighting)
                }
                "rock" -> {
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.rock)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_rock)
                }
                "flying" -> {
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.flying)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_flying)
                }
                "electric" -> {
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.electric)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_electric)
                }
                "bug" -> {
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.bug)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_bug)
                }
                "psychic" -> {
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.psychic)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_psychic)
                }
                "ground" -> {
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.ground)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_ground)
                }
                "fairy" -> {
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.fairy)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_flying)
                }
                "dark" -> {
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.dark)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_dark)
                }
                "normal" -> {
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.normal)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_flying)
                }
                else -> {
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.pokeboll)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_normal)
                }
            }
        }
    }
}
