package com.cervantes.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.cervantes.poketinder.databinding.ActivityRegisterBinding
import com.cervantes.poketinder.ui.viewmodel.RegisterViewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate){

    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerViewModel = RegisterViewModel(this)
        registerViewModel.onCreate()
        registerViewModel.emptyFieldsError.observe(this) {
            Toast.makeText(this, "Introduzca su nombre de Usuario por favor", Toast.LENGTH_SHORT).show()
        }
        registerViewModel.fieldsAuthenticateError.observe(this) {
            Toast.makeText(this, "Error las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
        }

        registerViewModel.goalSuccesActivity.observe(this){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
    fun registerUser(view: View){
        registerViewModel.validateInputs(binding.edtUserName.text.toString(),
            binding.edtEmail.text.toString(),binding.edtPassword.text.toString(),binding.edtPassword2.text.toString()
        )
    }
    fun loginUser(view: View){
        val intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)
    }
}