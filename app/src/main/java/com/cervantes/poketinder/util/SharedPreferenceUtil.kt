package com.cervantes.poketinder.util

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.cervantes.poketinder.data.model.User
import com.google.gson.Gson

class SharedPreferenceUtil{
    companion object {
        private const val SHARED_PREFERENCE_KEY = "SHARD_PREFERENCE_KEY"

        private lateinit var sharedPreference: SharedPreferences

        private const val USER = "USER"

        private const val INTRO = "INTRO"
    }

    fun setSharedPreference(context: Context) {
        sharedPreference = context
            .getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE)
    }

    fun saveFacebookUser(user: User) {

        val gson = Gson()

        val jsonFacebookUser = gson.toJson(user)

        sharedPreference
            .edit()
            .putString(USER, jsonFacebookUser)
            .apply()
    }
    //Esta función simula una mini-database, por lo que es un sinonimo de cookies y obtienes al igual que HTML una clave y valor
    fun getUser(): User? {

        var userFacebook: User? = null

        val jsonUserFacebook = sharedPreference.getString(USER, "")

        try {
            userFacebook = Gson().fromJson(jsonUserFacebook, User::class.java)
        } catch (e: Exception) {
            Log.d("Codercool", e.message.toString())
        }

        return userFacebook
    }

    //Esta función guardan un Booleano, y lo que hace
    // es guardar cada visita del OnBoarding de los usuarios, y no vuelve aparecer si ya fue visitada antes
    //Se guarda con la variable INTRO y se le da el true
    fun saveIntroShow() {
        sharedPreference
            .edit()
            .putBoolean(INTRO, true)
            .apply()
    }

    //Esta función realiza la validación de si paso o no paso la variable INTRO
    fun getIntroShow(): Boolean = sharedPreference
        .getBoolean(INTRO, false)

}