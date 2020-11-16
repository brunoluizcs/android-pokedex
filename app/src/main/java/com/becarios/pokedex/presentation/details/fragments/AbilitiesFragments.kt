package com.becarios.pokedex.presentation.details.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.becarios.pokedex.R
import kotlinx.android.synthetic.main.fragment_abilities.*
import java.util.*

class AbilitiesFragments : Fragment() {
    var value = String()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val viewModel = ViewModelProvider(this).get(AbilitiesViewModel::class.java)
       val viewModel2 = ViewModelProvider(this).get(DescriptionViewModel::class.java)

        viewModel.mLiveData.observe(this, androidx.lifecycle.Observer {
            it?.let { abilities ->
                ability1.text = abilities[0].name1.capitalize(Locale.ROOT)
                ability2.text = abilities[1].name2.capitalize(Locale.ROOT)

                val url1 = abilities[0].url1
                val url2 = abilities[1].url2
                val url1Split = url1.split("/").map { it.trim() }
                val url2Split = url2.split("/").map { it.trim() }
                val url1Formatter = url1Split[6]
                val url2Formatter = url2Split[6]
                viewModel2.getDescription(url1Formatter, url2Formatter)
            }
        })
        viewModel.getAbilities(value)

        viewModel2.mLiveData.observe(this, androidx.lifecycle.Observer {
            it?.let { descriptions -> dscAbility1.text = descriptions[1].effect.capitalize(Locale.ROOT)
            }})

        viewModel2.mLiveData2.observe(this, androidx.lifecycle.Observer {
            it?.let { descriptions -> dscAbility2.text = descriptions[1].effect.capitalize(Locale.ROOT)
            }})
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_abilities, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(id: String, type: String) = AbilitiesFragments().apply {
            arguments = Bundle().apply { putString("ID", "id")
                value = id
            }
        }
    }
}