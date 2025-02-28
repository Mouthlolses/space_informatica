package com.example.space_informatica.ui.client

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.space_informatica.R
import com.example.space_informatica.databinding.ActivityClientBinding
import com.example.space_informatica.ui.screens_initial.LoginActivity
import com.google.firebase.auth.FirebaseAuth

class ClientActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityClientBinding.inflate(layoutInflater)
    }

    private val autentication by lazy {
        FirebaseAuth.getInstance()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(binding.root)


        //Configurar Caminho da opção Manutenções
        binding.cardView.setOnClickListener {
            val intent = Intent(this, ManutenActivity::class.java)
            (startActivity(intent))
        }

        binding.button.setOnClickListener {
            deslogarUsuario()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun deslogarUsuario() {
        autentication.signOut()
        Toast.makeText(this, "Usuario Deslogado", Toast.LENGTH_LONG).show()
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
