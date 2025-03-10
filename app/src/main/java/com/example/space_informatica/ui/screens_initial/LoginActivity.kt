package com.example.space_informatica.ui.screens_initial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.space_informatica.R
import com.example.space_informatica.databinding.ActivityLoginBinding
import com.example.space_informatica.ui.client.ClientActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    private val autentication by lazy {
        FirebaseAuth.getInstance()
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
        setupListeners()
        /*binding.btnRegister.setOnClickListener {
            registerUser()
        }*/

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


    private fun logarUser() {

        val email = binding.email
        val password = binding.Password

        autentication.signInWithEmailAndPassword(
            email.text.toString(), password.text.toString()
        ).addOnSuccessListener { authResult ->
            Toast.makeText(this, "Usuario Logado", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, ClientActivity::class.java))
            finish()
        }.addOnFailureListener { exception ->
            Toast.makeText(this, "Falha ao Logar: ${exception}", Toast.LENGTH_LONG).show()
        }
    }

    //Amostra de autenticação via loginFirebase
    private fun registerUser() {

        val email = binding.email
        val password = binding.Password

        autentication.createUserWithEmailAndPassword(
            email.text.toString(), password.text.toString()
        ).addOnSuccessListener { authResult ->

            val email = authResult.user?.email
            val id = authResult.user?.uid

            exibirMensagem("Sucesso ao cadastrar usuario: $id - $email")

        }.addOnFailureListener { exception ->
            exibirMensagem("Erro ao cadastrar usuario ${exception.message}")
        }

    }

    private fun exibirMensagem(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()

    }


    private fun setupListeners() {
        binding.btnAcess.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.Password.text.toString()

            if (validateEntryLogin(email, password)) {
                entry()
            }
        }
    }

    private fun entry() {
        val intent = Intent(this, ClientActivity::class.java)
        startActivity(intent)
    }

    private fun validateEntryLogin(lEmail: String, lPassword: String): Boolean {

        binding.loginEmail.error = null
        binding.loginPassword.error = null

        if (lEmail.isEmpty()) {
            binding.loginEmail.error = "Digite seu email"
            return false
        } else if (lPassword.isEmpty()) {
            binding.loginPassword.error = "Digite sua senha"
            return false
        }
        return true
    }

}