package com.example.space_informatica.ui.screens_initial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.space_informatica.R
import com.example.space_informatica.databinding.ActivityLoginBinding
import com.example.space_informatica.ui.client.ClientActivity

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(binding.root)
        setupListeners()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
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