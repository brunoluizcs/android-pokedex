package com.becarios.pokedex.presentation.details.fragments

import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat
import androidx.recyclerview.widget.RecyclerView
import com.becarios.pokedex.R
import com.becarios.pokedex.data.model.EvolutionChain2
import com.bumptech.glide.Glide
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.evolution_recycler_item.view.*
import java.util.*

var listSize = 2
class EvolutionAdapter(private val pokemonsEvolution: List<EvolutionChain2>, val onItemClickListener:
((pokemon: EvolutionChain2) -> Unit)) : RecyclerView.Adapter<EvolutionAdapter.PokemonsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonsViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.evolution_recycler_item, parent, false)
        return PokemonsViewHolder(view, onItemClickListener)

    }

    override fun onBindViewHolder(viewholder: PokemonsViewHolder, position: Int) {
        viewholder.bindView(pokemonsEvolution[position])
    }

    override fun getItemCount() = listSize

    inner class viewHolderTwo(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindItemOne(item: EvolutionViewModel){
            var evolutionTxt1 = itemView.evolutionTxt1
            var evolutionTxt2 = itemView.evolutionTxt2
            var image1 = itemView.evolutionSprite1
            var image2 = itemView.evolutionSprite2
        }
    }

    class PokemonsViewHolder(itemView: View, private val onItemClickListener:
    ((pokemon: EvolutionChain2) -> Unit)) : RecyclerView.ViewHolder(itemView) {


        private val evolutionTxt1 = itemView.evolutionTxt1
        private val evolutionTxt2 = itemView.evolutionTxt2
        private val spritePoke = itemView.evolutionSprite1
        private val image1 = itemView.evolutionSprite1
        private val image2 = itemView.evolutionSprite2

        fun bindView(pokemonsEvolution: EvolutionChain2) {
            when(pokemonsEvolution.status) {
                "notFound" -> {
                    Handler(Looper.getMainLooper()).postDelayed({
                        listSize = 2
                        Toasty.custom(itemView.context, "${pokemonsEvolution.name1.
                        capitalize(Locale.ROOT)} não possui evoluções!", R.drawable.poke_icon, Color.BLACK,
                            4, true, true).show()
                    }, 10)
                }
                "foundEvo1" -> {
                    Handler(Looper.getMainLooper()).postDelayed({
                        listSize = 1
                        listingEvolutions(pokemonsEvolution)
                    }, 10)
                }
                "foundEvo2" -> {
                    Handler(Looper.getMainLooper()).postDelayed({
                        listSize = 2
                        listingEvolutions(pokemonsEvolution)
                    }, 10)
                }
            }

            itemView.setOnClickListener {
                var pokemon1 = pokemonsEvolution.name1.capitalize(Locale.ROOT)
                var pokemon2 = pokemonsEvolution.name2.capitalize(Locale.ROOT)
                Toasty.custom(itemView.context, "$pokemon1 evolui para $pokemon2!", R.drawable.pokebola_icon, Color.BLACK, 4, true, true).show()
            }
        }

        fun listingEvolutions(pokemonsEvolution: EvolutionChain2){

            evolutionTxt1.text = pokemonsEvolution.name1.capitalize(Locale.ROOT)
            evolutionTxt2.text = pokemonsEvolution.name2.capitalize(Locale.ROOT)
            spritePoke.importantForAccessibility
            spritePoke.contentDescription = pokemonsEvolution.name1.capitalize(Locale.ROOT)

            val url1 = pokemonsEvolution.url1.split("/").map { it.trim() }
            val url2 = pokemonsEvolution.url2.split("/").map { it.trim() }
            val imageId1 = url1[6]
            val imageId2 = url2[6]

            Glide.with(itemView)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${imageId1}.png")
                .error(R.drawable.pokeboll)
                .centerCrop()
                .into(image1)

            Glide.with(itemView)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${imageId2}.png")
                .error(R.drawable.pokeboll)
                .centerCrop()
                .into(image2)
        }
    }
}
