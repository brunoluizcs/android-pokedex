package com.becarios.pokedex.presentation.details.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.becarios.pokedex.R
import kotlinx.android.synthetic.main.fragment_evolution.*

var idValue = String()
var nameValue = String()
class EvolutionFragment : Fragment() {
    var chainId = String()
    var imageId1 = String()
    var imageId2 = String()
    var imageId3 = String()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this).get(EvolutionViewModel::class.java)

        viewModel.mLiveData.observe(this, androidx.lifecycle.Observer {
            it?.let { evolution ->

                val url1Split = evolution[0].url.split("/").map { it.trim() }
                val id = url1Split[6] //Capturado o ID da cadeia de evolução

                viewModel.getEvolutionChain(id)
            }
        })

        viewModel.getEvolution(idValue)

        viewModel.mLiveData2.observe(this, androidx.lifecycle.Observer {
            it?.let { evolution ->
                with(recyclerEvolution) {
                    layoutManager = GridLayoutManager(this@EvolutionFragment.context, 1)
                    setHasFixedSize(true)
                    adapter = EvolutionAdapter(evolution) {
                    }
                }
            }
            onStart()
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_evolution, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(id: String, name: String) = EvolutionFragment().apply {
            arguments = Bundle().apply {
                putString("ID", "id")
                putString("NAME", "name")
                idValue = id
                nameValue = name
            }
        }
    }
}