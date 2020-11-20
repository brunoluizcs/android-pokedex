package com.becarios.pokedex.presentation.pokemons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.becarios.pokedex.R
import com.becarios.pokedex.data.model.Pokemons
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.pokemon_recycler_item.view.*
import util.Constant
import java.util.*

class PokemonAdapter(
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
        itemView: View, private val onItemClickListener:
        ((pokemon: Pokemons) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.txt_pokemon_name
        private val id = itemView.txt_pokemon_id
        private val image = itemView.imagePokemon

        fun bindView(pokemon: Pokemons) {
            val idInt: Int = pokemon.id.toInt()
            name.text = pokemon.name.capitalize(Locale.ROOT)

            when {
                idInt < 10 -> {
                    id.text = ("00${idInt}")
                }
                idInt in 10..99 -> {
                    id.text = ("0${idInt}")
                }
                else -> id.text = ("${idInt}")
            }

            val id = pokemon.id

            Glide.with(itemView)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${id}.png")
                .error(R.drawable.pokeboll)
                .centerCrop()
                .into(image)


            itemView.setOnClickListener {
                onItemClickListener.invoke(pokemon)
            }

            var connector = String()
            if (pokemon.typeName1 == pokemon.typeName2) {
                itemView.pokemon_type_two.visibility = View.GONE
            }

            when (pokemon.typeName1) {
                Constant.FIRE -> {
                    val typeNamePtBr1 = "fogo"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.fire)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_fire)
                    itemView.pokemon_type_one.contentDescription = "Pokemon do tipo $typeNamePtBr1"
                }
                Constant.WATER -> {
                    val typeNamePtBr_1 = "agua"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.water)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_water)
                    itemView.pokemon_type_one.contentDescription = "Pokemon do tipo $typeNamePtBr_1"
                }
                Constant.ICE -> {
                    val typeNamePtBr_1 = "gelo"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.ice)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_water)
                    itemView.pokemon_type_one.contentDescription = "Pokemon do tipo $typeNamePtBr_1"
                }
                Constant.GRASS -> {
                    val typeNamePtBr_1 = "planta"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.grass)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_grass)
                    itemView.pokemon_type_one.contentDescription = "Pokemon do tipo $typeNamePtBr_1"
                }
                Constant.POISON -> {
                    val typeNamePtBr_1 = "veneno"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.poison)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_poison)
                    itemView.pokemon_type_one.contentDescription = "Pokemon do tipo $typeNamePtBr_1"
                }
                Constant.FIGHTING -> {
                    val typeNamePtBr_1 = "lutador"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.fighting)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_fighting)
                    itemView.pokemon_type_one.contentDescription = "Pokemon do tipo $typeNamePtBr_1"
                }
                Constant.ROCK -> {
                    val typeNamePtBr_1 = "rocha"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.rock)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_rock)
                    itemView.pokemon_type_one.contentDescription = "Pokemon do tipo $typeNamePtBr_1"
                }
                Constant.FLYING -> {
                    val typeNamePtBr_1 = "voador"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.flying)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_flying)
                    itemView.pokemon_type_one.contentDescription = "Pokemon do tipo $typeNamePtBr_1"
                }
                Constant.DRAGON -> {
                    val typeNamePtBr_1 = "voador"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.dragon)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_dragon)
                    itemView.pokemon_type_one.contentDescription = "Pokemon do tipo $typeNamePtBr_1"
                }
                Constant.ELECTRIC -> {
                    val typeNamePtBr_1 = "elétrico"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.electric)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_electric)
                    itemView.pokemon_type_one.contentDescription = "Pokemon do tipo $typeNamePtBr_1"
                }
                Constant.BUG -> {
                    val typeNamePtBr_1 = "inseto"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.bug)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_bug)
                    itemView.pokemon_type_one.contentDescription = "Pokemon do tipo $typeNamePtBr_1"
                }
                Constant.PSYCHIC -> {
                    val typeNamePtBr_1 = "psíquico"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.psychic)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_psychic)
                    itemView.pokemon_type_one.contentDescription = "Pokemon do tipo $typeNamePtBr_1"
                }
                Constant.GROUND -> {
                    val typeNamePtBr_1 = "terra"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.ground)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_ground)
                    itemView.pokemon_type_one.contentDescription = "Pokemon do tipo $typeNamePtBr_1"
                }
                Constant.FAIRY -> {
                    val typeNamePtBr_1 = "fada"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.fairy)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_flying)
                    itemView.pokemon_type_one.contentDescription = "Pokemon do tipo $typeNamePtBr_1"
                }
                Constant.DARK -> {
                    val typeNamePtBr_1 = "sombra"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.dark)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_dark)
                    itemView.pokemon_type_one.contentDescription = "Pokemon do tipo $typeNamePtBr_1"
                }
                Constant.GHOST -> {
                    val typeNamePtBr_1 = "fantasma"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.ghost)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_ghost)
                    itemView.pokemon_type_one.contentDescription = "Pokemon do tipo $typeNamePtBr_1"
                }
                Constant.STEEL -> {
                    val typeNamePtBr_2 = "metal"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.iron)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_iron)
                    itemView.pokemon_type_one.contentDescription = "Pokemon do tipo $typeNamePtBr_2"
                }
                Constant.NORMAL -> {
                    val typeNamePtBr_1 = "normal"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.normal)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_normal)
                    itemView.pokemon_type_one.contentDescription = "Pokemon do tipo $typeNamePtBr_1"
                }
                else -> {
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.pokeboll)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_normal)
                    itemView.pokemon_type_two.contentDescription =
                        "Pokemon do tipo ${pokemon.typeName1}"
                }
            }

            when (pokemon.typeName2 == pokemon.typeName1) {
                true -> {
                    itemView.pokemon_type_one.visibility = View.GONE
                    connector = "Pokemon do tipo"
                }
                else -> connector = "e"
            }

            when (pokemon.typeName2) {
                Constant.FIRE -> {
                    val typeNamePtBr_2 = "fogo"
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.fire)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_fire)
                    itemView.pokemon_type_two.contentDescription = "$connector $typeNamePtBr_2"
                }
                Constant.WATER -> {
                    val typeNamePtBr_2 = "agua"
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.water)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_water)
                    itemView.pokemon_type_two.contentDescription = "$connector $typeNamePtBr_2"
                }
                Constant.ICE -> {
                    val typeNamePtBr_2 = "gelo"
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.ice)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_water)
                    itemView.pokemon_type_two.contentDescription = "connector $typeNamePtBr_2"
                }
                Constant.GRASS -> {
                    val typeNamePtBr_2 = "planta"
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.grass)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_grass)
                    itemView.pokemon_type_two.contentDescription = "$connector $typeNamePtBr_2"
                }
                Constant.POISON -> {
                    val typeNamePtBr_2 = "veneno"
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.poison)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_poison)
                    itemView.pokemon_type_two.contentDescription = "$connector $typeNamePtBr_2"
                }
                Constant.FIGHTING -> {
                    val typeNamePtBr_2 = "lutador"
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.fighting)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_fighting)
                    itemView.pokemon_type_two.contentDescription = "$connector $typeNamePtBr_2"
                }
                Constant.ROCK -> {
                    val typeNamePtBr_2 = "rocha"
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.rock)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_rock)
                    itemView.pokemon_type_two.contentDescription = "$connector $typeNamePtBr_2"
                }
                Constant.FLYING -> {
                    val typeNamePtBr_2 = "voador"
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.flying)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_flying)
                    itemView.pokemon_type_two.contentDescription = "$connector $typeNamePtBr_2"
                }
                Constant.DRAGON -> {
                    val typeNamePtBr_2 = "voador"
                    itemView.pokemon_type_one.visibility = View.VISIBLE
                    itemView.pokemon_type_one.setImageResource(R.drawable.dragon)
                    itemView.pokemon_type_one.setBackgroundResource(R.drawable.circle_dragon)
                    itemView.pokemon_type_one.contentDescription = "$connector $typeNamePtBr_2"
                }
                Constant.ELECTRIC -> {
                    val typeNamePtBr_2 = "elétrico"
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.electric)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_electric)
                    itemView.pokemon_type_two.contentDescription = "$connector $typeNamePtBr_2"
                }
                Constant.BUG -> {
                    val typeNamePtBr_2 = "inceto"
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.bug)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_bug)
                    itemView.pokemon_type_two.contentDescription = "$connector $typeNamePtBr_2"
                }
                Constant.PSYCHIC -> {
                    val typeNamePtBr_2 = "lutador"
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.psychic)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_psychic)
                    itemView.pokemon_type_two.contentDescription = "$connector $typeNamePtBr_2"
                }
                Constant.GROUND -> {
                    val typeNamePtBr_2 = "terra"
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.ground)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_ground)
                    itemView.pokemon_type_two.contentDescription = "$connector $typeNamePtBr_2"
                }
                Constant.FAIRY -> {
                    val typeNamePtBr_2 = "fada"
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.fairy)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_flying)
                    itemView.pokemon_type_two.contentDescription = "$connector $typeNamePtBr_2"
                }
                Constant.DARK -> {
                    val typeNamePtBr_2 = "sombra"
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.dark)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_dark)
                    itemView.pokemon_type_two.contentDescription = "$connector $typeNamePtBr_2"
                }
                Constant.GHOST -> {
                    val typeNamePtBr_1 = "fantasma"
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.ghost)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_ghost)
                    itemView.pokemon_type_two.contentDescription = "$connector $typeNamePtBr_1"
                }
                Constant.STEEL -> {
                    val typeNamePtBr_2 = "metal"
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.iron)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_iron)
                    itemView.pokemon_type_two.contentDescription = "$connector $typeNamePtBr_2"
                }
                Constant.NORMAL -> {
                    val typeNamePtBr_2 = "normal"
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.normal)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_normal)
                    itemView.pokemon_type_two.contentDescription = "$connector $typeNamePtBr_2"
                }
                else -> {
                    itemView.pokemon_type_two.visibility = View.VISIBLE
                    itemView.pokemon_type_two.setImageResource(R.drawable.pokeboll)
                    itemView.pokemon_type_two.setBackgroundResource(R.drawable.circle_normal)
                    itemView.pokemon_type_two.contentDescription = "$connector ${pokemon.typeName2}"
                }
            }
        }
    }
}
