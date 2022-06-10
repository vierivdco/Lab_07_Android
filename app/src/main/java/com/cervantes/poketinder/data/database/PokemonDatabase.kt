package com.cervantes.poketinder.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cervantes.poketinder.data.database.dao.PokemonDao
import com.cervantes.poketinder.data.database.entities.MyPokemonEntity

@Database(entities = [MyPokemonEntity::class], version = 1)
abstract class PokemonDatabase: RoomDatabase(){

    abstract fun getPokemonDao(): PokemonDao
}