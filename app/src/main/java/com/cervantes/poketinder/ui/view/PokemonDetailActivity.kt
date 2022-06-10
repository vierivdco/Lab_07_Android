package com.cervantes.poketinder.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cervantes.poketinder.databinding.ActivityPokemonDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailActivity: BaseActivity<ActivityPokemonDetailBinding>(ActivityPokemonDetailBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pokemonId = intent?.extras?.getString("ID_POKEMON", null)
        if(pokemonId != null){
            Toast.makeText(this,"PokemonId: $pokemonId", Toast.LENGTH_SHORT).show()
        }
    }
}