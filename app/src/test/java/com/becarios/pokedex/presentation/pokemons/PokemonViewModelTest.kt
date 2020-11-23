package com.becarios.pokedex.presentation.pokemons

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.becarios.pokedex.data.model.Pokemons
import com.becarios.pokedex.data.model.PokemonsId
import com.becarios.pokedex.data.repository.PokemonIdRepository
import com.becarios.pokedex.data.repository.PokemonRepositoryImp
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test

class PokemonViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()
    private val repositoryImp: PokemonRepositoryImp = mockk()
    private val repositoryIdImp: PokemonIdRepository = mockk()

    @Test
    fun `quando viewModel buscar dados então deve chamar o repositório`(){
        val viewModel = instantiateViewModel()
        val mockedPokemons = listOf<Pokemons>()

        coEvery {
            repositoryImp.getPokemonList()
        } returns mockedPokemons

        viewModel.getPokemons()

        coVerify { repositoryImp.getPokemonList(any()) }
    }

    @Test
    fun `quando viewModel buscar dados por Id então deve chamar o repositório`(){
        val viewModel = instantiateViewModel()
        val mockedPokemons = listOf<PokemonsId>()

        coEvery {
            repositoryIdImp.getPokemonList("1")
        } returns mockedPokemons

        viewModel.getPokemonId("1")

        coVerify { repositoryIdImp.getPokemonList(any()) }
    }

    private fun instantiateViewModel(): PokemonViewModel {
        val viewModel = PokemonViewModel(repositoryImp, repositoryIdImp)
        return PokemonViewModel(repositoryImp, repositoryIdImp)
    }
}