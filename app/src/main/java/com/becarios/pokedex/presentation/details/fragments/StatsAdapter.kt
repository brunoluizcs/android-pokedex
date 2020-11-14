package com.becarios.pokedex.presentation.details.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.becarios.pokedex.R
import com.becarios.pokedex.data.model.PokemonsStats
import kotlinx.android.synthetic.main.stats_item_adapter.view.*

class StatsAdapter(
    private val pokemonsStats: List<PokemonsStats>,
    val onItemClickListener: ((pokemon: PokemonsStats) -> Unit)
) : RecyclerView.Adapter<StatsAdapter.PokemonsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.stats_item_adapter, parent, false)
        return PokemonsViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(viewholder: PokemonsViewHolder, position: Int) {
        viewholder.bindView(pokemonsStats[position])
    }

    override fun getItemCount() = pokemonsStats.count()

    class PokemonsViewHolder(
        itemView: View, private val onItemClickListener:
        ((pokemon: PokemonsStats) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {
        private val statName = itemView.statName
        private val statValue = itemView.statValue
        private val progressStatBar = itemView.progressStatBar
        var stat_Name = String()
        fun bindView(pokemonStats: PokemonsStats) {


            when(pokemonStats.name){
                "hp"              -> stat_Name = "HP"
                "attack"          -> stat_Name = "ATK"
                "defense"         -> stat_Name = "DEF"
                "special-attack"  -> stat_Name = "SAT"
                "special-defense" -> stat_Name = "SDEF"
                "speed"           -> stat_Name = "SPD"
            }
            statName.text = stat_Name
            statValue.text = pokemonStats.base_stat1
            progressStatBar.progress = pokemonStats.base_stat1.toInt()


            itemView.setOnClickListener {
                onItemClickListener.invoke(pokemonStats)
            }
        }
    }
}
