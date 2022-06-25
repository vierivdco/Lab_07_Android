package com.cervantes.poketinder.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.cervantes.poketinder.databinding.ActivityPokemonDetailBinding
import com.cervantes.poketinder.ui.viewmodel.PokemonDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailActivity: BaseActivity<ActivityPokemonDetailBinding>(ActivityPokemonDetailBinding::inflate) {
    private val pokemonDetailViewModel: PokemonDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pokemonDetailViewModel.isLoading.observe(this) {
            binding.progressBar2.isVisible=it
        }

        pokemonDetailViewModel.pokemonDetailModel.observe(this){
            binding.tvName.text = it.name

            it.stats.forEach{
                Toast.makeText(this,"Stat: $it", Toast.LENGTH_SHORT).show()
            }

            for(i in 0 until it.stats.size){
                Toast.makeText(this,"Stat: ${it.stats.get(i)}", Toast.LENGTH_SHORT).show()
            }
        }
        val pokemonId = intent?.extras?.getString("ID_POKEMON", null)



        if(pokemonId != null){
            pokemonDetailViewModel.onCreate(pokemonId!!)
            Toast.makeText(this,"PokemonId: $pokemonId",Toast.LENGTH_SHORT).show()
        }

    }
}