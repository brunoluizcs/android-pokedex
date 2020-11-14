package com.becarios.pokedex.presentation.details.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.becarios.pokedex.R
import kotlinx.android.synthetic.main.fragment_stats.*

class StatsFragment : Fragment() {
    var value = String()
    private var id: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val statsViewModel: StatsViewModel = ViewModelProvider(this).get(StatsViewModel::class.java)

        statsViewModel.mLiveData.observe(this, Observer {

            it?.let { stats ->
                with(recyclerViewStats) {
                    layoutManager = GridLayoutManager(this@StatsFragment.context, 1)
                    setHasFixedSize(true)
                    adapter = StatsAdapter(stats) {
                    }
                }
            }
        })
        statsViewModel.getStats(value)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stats, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(id: String) = StatsFragment().apply { arguments = Bundle().apply {
            putString("ID", "id")
                value = id
            }
        }
    }
}