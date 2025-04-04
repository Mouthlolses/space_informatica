package com.example.space_informatica.ui.screens_initial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.space_informatica.R
import com.example.space_informatica.databinding.ActivityLoginBinding
import com.example.space_informatica.repository.AuthRepository
import com.example.space_informatica.ui.client.ClientActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    private val authRepository by lazy {
        AuthRepository(FirebaseAuth.getInstance())
    }

    /*override fun onStart() {
        super.onStart()
        verificarUsuarioLogado()
    }

    private fun verificarUsuarioLogado() {
        val usuario = autentication.currentUser
        val id = usuario?.uid
        if (usuario != null) {
            startActivity(
                Intent(this, ClientActivity::class.java)
            )
            exibirMensagem("Usuario está logado com id: $id")
        } else {
            exibirMensagem("Usuario não está logado")
        }
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(binding.root)
        binding.btnRegister.setOnClickListener {
            registerUser()
        }
        binding.btnAcess.setOnClickListener {
            logarUser()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    //autenticação via Firebase // ja editado
    private fun logarUser() {
        val email = binding.email.text.toString().trim()
        val password = binding.Password.text.toString().trim()

        authRepository.logarUser(email, password) { success, message ->
            exibirMensagem(message)
            if (success) {
                entry()
                finish()
            }
        }
    }

    //login via Firebase/// ja editado
    private fun registerUser() {
        val email = binding.email.text.toString().trim()
        val password = binding.Password.text.toString().trim()

        authRepository.registerUser(email, password) { _, message ->
            exibirMensagem(message)
        }
    }

    private fun exibirMensagem(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    private fun entry() {
        val intent = Intent(this, ClientActivity::class.java)
        startActivity(intent)
    }
}

