package com.example.space_informatica.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.space_informatica.R
import com.example.space_informatica.databinding.StartscreenActivityBinding
import com.example.space_informatica.receivers.NetworkMonitor
import com.example.space_informatica.ui.screens_initial.LoginActivity
import com.example.space_informatica.ui.screens_initial.PlanosActivity
import com.example.space_informatica.utils.NetworkUtils.isNetworkAvailable


class StartScreenActivity : AppCompatActivity() {

    private val binding by lazy {
        StartscreenActivityBinding.inflate(layoutInflater)
    }
    private val networkMonitor by lazy {
        NetworkMonitor(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Deginindo o layout a partir do binding
        setContentView(binding.root)

        // Inicializar o monitor de conectividade
        networkMonitor.registerCallback()
        if (!isNetworkAvailable(this)) {
            Toast.makeText(this, "Sem conexão com a internet", Toast.LENGTH_SHORT).show()
        }

        //Configuração do Caminho para a tela de Planos
        binding.buttonParaPlanosSheet.setOnClickListener {
            val intent = Intent(this, PlanosActivity::class.java)
            (startActivity(intent))
        }

        //Configuração do Caminho para a tela de Login
        binding.buttonParaLoginSheet.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            (startActivity(intent))
        }

        //enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}