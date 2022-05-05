package com.cervantes.poketinder.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.cervantes.poketinder.R
import com.cervantes.poketinder.data.User
import com.cervantes.poketinder.databinding.ActivityLoginBinding
import com.cervantes.poketinder.util.SharedPreferenceUtil


abstract class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate){

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferenceUtil = sharedPreferenceUtil.also{
            it.setSharedPreference(this)
        }
    }

    fun validateInput(){
        if (binding.edtEmail.text.isEmpty() && binding.edtPassword.text.isEmpty()){
            //Agregar toast
        }
    }

    fun startLogin(view: View){
        //validateInput()
        if(binding.edtEmail.text.isEmpty() && binding.edtPassword.text.isEmpty()){
            Toast.makeText(this, "No ha ingresado sus datos",Toast.LENGTH_SHORT).show()
        }else if(binding.edtEmail.text.isEmpty()){
            Toast.makeText(this,"No ha ingresado su correo",Toast.LENGTH_SHORT).show()
        }else if(binding.edtPassword.text.isEmpty()){
            Toast.makeText(this,"No ha ingresado su contraseña",Toast.LENGTH_SHORT).show()

        }else{
            val user: User? = sharedPreferenceUtil.getUser()

            if (user?.email.equals(binding.edtEmail.text.toString()) && user?.password.equals(binding.edtPassword.text.toString())) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("user",user)
                startActivity(intent)
            }else {
                Toast.makeText(this, "Error usuario", Toast.LENGTH_SHORT).show()
            }
        }
        
    }
}