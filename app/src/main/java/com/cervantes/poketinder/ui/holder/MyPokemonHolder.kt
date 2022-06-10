package com.cervantes.poketinder.ui.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cervantes.poketinder.databinding.ItemPokemonSavedBinding
import com.cervantes.poketinder.domain.model.MyPokemon
import com.cervantes.poketinder.util.formatNumberTo3Digits

class MyPokemonsHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemPokemonSavedBinding.bind(view)

    fun bind(pokemon: MyPokemon) {
        with(binding) {
            tvIndex.text = formatNumberTo3Digits(pokemon.idPokemon.toInt())
            tvName.text = pokemon.name
            tvType.text = if (pokemon.isLegendary) "Legendary" else "Normal"
            Glide
                .with(itemView)
                .load(pokemon.image)
                .into(binding.ivPokemonLogo)
        }
    }
}