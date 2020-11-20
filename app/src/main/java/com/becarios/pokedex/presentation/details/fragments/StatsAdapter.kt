package com.becarios.pokedex.presentation.details.fragments

import android.graphics.Color
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
        itemView: View, private val onItemClickListener: ((pokemon: PokemonsStats) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {
        private val statName = itemView.statName
        private val statValue = itemView.statValue
        private val progressStatBar = itemView.progressStatBar

        var stat_Name = String()

        fun bindView(pokemonStats: PokemonsStats) {

            when (pokemonStats.name) {
                "hp" -> stat_Name = "HP"
                "attack" -> stat_Name = "ATK"
                "defense" -> stat_Name = "DEF"
                "special-attack" -> stat_Name = "SAT"
                "special-defense" -> stat_Name = "SDEF"
                "speed" -> stat_Name = "SPD"
            }

            statName.text = stat_Name
            statValue.text = pokemonStats.base_stat1
            progressStatBar.progress = pokemonStats.base_stat1.toInt()
            itemView.setOnClickListener {
                onItemClickListener.invoke(pokemonStats)
            }

            when (pokemonStats.pokemonType) {
                util.Constant.FIRE -> {
                    progressStatBar.progressDrawable.setTint(Color.parseColor("#FF9424"))
                    statName.setTextColor(Color.parseColor("#FF9424"))
                    statValue.setTextColor(Color.parseColor("#FF9424"))
                }
                util.Constant.WATER -> {
                    progressStatBar.progressDrawable.setTint(Color.parseColor("#559EDF"))
                    statName.setTextColor(Color.parseColor("#559EDF"))
                    statValue.setTextColor(Color.parseColor("#559EDF"))
                }
                util.Constant.ICE -> {
                    progressStatBar.progressDrawable.setTint(Color.parseColor("#28C5A"))
                    statName.setTextColor(Color.parseColor("#28C5A"))
                    statValue.setTextColor(Color.parseColor("#28C5A"))
                }
                util.Constant.GRASS -> {
                    progressStatBar.progressDrawable.setTint(Color.parseColor("#5DBE62"))
                    statName.setTextColor(Color.parseColor("#5DBE62"))
                    statValue.setTextColor(Color.parseColor("#5DBE62"))
                }
                util.Constant.POISON -> {
                    progressStatBar.progressDrawable.setTint(Color.parseColor("#B563CE"))
                    statName.setTextColor(Color.parseColor("#B563CE"))
                    statValue.setTextColor(Color.parseColor("#B563CE"))
                }
                util.Constant.FIGHTING -> {
                    progressStatBar.progressDrawable.setTint(Color.parseColor("#D94256"))
                    statName.setTextColor(Color.parseColor("#D94256"))
                    statValue.setTextColor(Color.parseColor("#D94256"))
                }
                util.Constant.ROCK -> {
                    progressStatBar.progressDrawable.setTint(Color.parseColor("#B98325"))
                    statName.setTextColor(Color.parseColor("#B98325"))
                    statValue.setTextColor(Color.parseColor("#B98325"))
                }
                util.Constant.FLYING -> {
                    progressStatBar.progressDrawable.setTint(Color.parseColor("#569AB4"))
                    statName.setTextColor(Color.parseColor("#569AB4"))
                    statValue.setTextColor(Color.parseColor("#569AB4"))
                }
                util.Constant.DRAGON -> {
                    progressStatBar.progressDrawable.setTint(Color.parseColor("#0773C7"))
                    statName.setTextColor(Color.parseColor("#0773C7"))
                    statValue.setTextColor(Color.parseColor("#0773C7"))
                }
                util.Constant.ELECTRIC -> {
                    progressStatBar.progressDrawable.setTint(Color.parseColor("#E6BE1A"))
                    statName.setTextColor(Color.parseColor("#E6BE1A"))
                    statValue.setTextColor(Color.parseColor("#E6BE1A"))
                }
                util.Constant.BUG -> {
                    progressStatBar.progressDrawable.setTint(Color.parseColor("#9DC130"))
                    statName.setTextColor(Color.parseColor("#9DC130"))
                    statValue.setTextColor(Color.parseColor("#9DC130"))
                }
                util.Constant.PSYCHIC -> {
                    progressStatBar.progressDrawable.setTint(Color.parseColor("#F87C7A"))
                    statName.setTextColor(Color.parseColor("#F87C7A"))
                    statValue.setTextColor(Color.parseColor("#F87C7A"))
                }
                util.Constant.GROUND -> {
                    progressStatBar.progressDrawable.setTint(Color.parseColor("#D78555"))
                    statName.setTextColor(Color.parseColor("#D78555"))
                    statValue.setTextColor(Color.parseColor("#D78555"))
                }
                util.Constant.FAIRY -> {
                    progressStatBar.progressDrawable.setTint(Color.parseColor("#FF51ED"))
                    statName.setTextColor(Color.parseColor("#FF51ED"))
                    statValue.setTextColor(Color.parseColor("#FF51ED"))
                }
                util.Constant.DARK -> {
                    progressStatBar.progressDrawable.setTint(Color.parseColor("#5F606D"))
                    statName.setTextColor(Color.parseColor("#5F606D"))
                    statValue.setTextColor(Color.parseColor("#5F606D"))
                }
                util.Constant.GHOST -> {
                    progressStatBar.progressDrawable.setTint(Color.parseColor("#6970C5"))
                    statName.setTextColor(Color.parseColor("#6970C5"))
                    statValue.setTextColor(Color.parseColor("#6970C5"))
                }
                util.Constant.STEEL -> {
                    progressStatBar.progressDrawable.setTint(Color.parseColor("#338597"))
                    statName.setTextColor(Color.parseColor("#338597"))
                    statValue.setTextColor(Color.parseColor("#338597"))
                }
                util.Constant.NORMAL -> {
                    progressStatBar.progressDrawable.setTint(Color.parseColor("#7E7E7E"))
                    statName.setTextColor(Color.parseColor("#7E7E7E"))
                    statValue.setTextColor(Color.parseColor("#7E7E7E"))
                }
            }
        }
    }
}