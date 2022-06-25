package com.cervantes.poketinder.ui.view

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.cervantes.poketinder.databinding.ActivityLoginBinding.inflate
import com.cervantes.poketinder.databinding.FragmentFavoriteBinding
import com.cervantes.poketinder.domain.model.MyPokemon
import com.cervantes.poketinder.ui.adapter.MyPokemonsAdapter
import com.cervantes.poketinder.ui.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment:BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate) {
    private var listMyPokemon = mutableListOf<MyPokemon>()
    private val adapter by lazy { MyPokemonsAdapter(listMyPokemon) }
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        viewModel.onCreate()
        binding.rvPokemons.adapter = adapter

        viewModel.myPokemonList.observe(this){
            listMyPokemon.clear()
            listMyPokemon.addAll(it)
            adapter.notifyDataSetChanged()
        }

        binding.floatingActionDelete.setOnClickListener{
            viewModel.deleteAllPokemon()
            listMyPokemon.clear()
            adapter.notifyDataSetChanged()
        }
    }
}