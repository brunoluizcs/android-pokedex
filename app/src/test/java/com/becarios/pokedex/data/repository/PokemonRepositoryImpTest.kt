package com.becarios.pokedex.data.repository

import com.becarios.pokedex.data.response.listagem.PokemonRootResponse
import com.becarios.pokedex.data.response.listagem.PokemonRootResult
import com.becarios.pokedex.data.response.listagem.PokemonTypeResult
import com.becarios.pokedex.data.service.PokemonService
import com.google.common.truth.Truth
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PokemonRepositoryImpTest {
    @Test
    fun quando_getPokemonList_deve_chamar_service_getPokemonId() = runBlocking{
        val fakeAPI = mockk<PokemonService>()
        val pokemonRootResponse = PokemonRootResponse("name", "id", listOf(PokemonRootResult(
            PokemonTypeResult("name", "url"))))
        coEvery { fakeAPI.getPokemonsById(any()) } returns pokemonRootResponse

        val repositoryImp = PokemonRepositoryImp(fakeAPI)

        repositoryImp.getPokemonList()

        coVerify { fakeAPI.getPokemonsById(any()) }
    }

    @Test
    fun quando_getPokemonList_deve_retornar_50_itens() = runBlocking {
        val fakeAPI = mockk<PokemonService>()
        val pokemonRootResponse = PokemonRootResponse("name", "id", listOf(PokemonRootResult(
            PokemonTypeResult("name", "url")
        )))
        coEvery { fakeAPI.getPokemonsById(any()) } returns pokemonRootResponse

        val repositoryImp = PokemonRepositoryImp(fakeAPI)

        val result = repositoryImp.getPokemonList()

        Truth.assertThat(result.size).isEqualTo(50)
    }
}
