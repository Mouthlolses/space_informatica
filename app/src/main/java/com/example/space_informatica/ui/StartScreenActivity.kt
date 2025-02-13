package com.example.space_informatica.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.space_informatica.R
import com.example.space_informatica.databinding.StartscreenActivityBinding
import com.example.space_informatica.receivers.NetworkMonitor
import com.example.space_informatica.ui.screens_initial.LoginActivity
import com.example.space_informatica.ui.screens_initial.PlanosActivity
import com.example.space_informatica.utils.NetworkUtils.isNetworkAvailable
import com.google.android.material.bottomsheet.BottomSheetBehavior


class StartScreenActivity : AppCompatActivity() {

    //private lateinit var binding: StartscreenActivityBinding
    private lateinit var planos: Button
    private lateinit var login: Button
    private lateinit var networkMonitor: NetworkMonitor

    //Substitui a inicialização padrão do binding
    private val binding by lazy {
        StartscreenActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Definindo o layout a partir do binding
        setContentView(binding.root)

        // Inicializar o monitor de conectividade
        networkMonitor = NetworkMonitor(this)
        networkMonitor.registerCallback()


        if (!isNetworkAvailable(this)) {
            Toast.makeText(this, "Sem conexão com a internet", Toast.LENGTH_SHORT).show()
        }

        //Configuração do Caminho para a tela de Planos
        planos = binding.buttonParaPlanosSheet
        planos.setOnClickListener {
            val intent = Intent(this, PlanosActivity::class.java)
            (startActivity(intent))
        }

        //Configuração do Caminho para a tela de Login
        login = binding.buttonParaLoginSheet
        login.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            (startActivity(intent))
        }


        // Referência ao Bottom Sheet
        val bottomsheet = binding.standardBottomSheet
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomsheet)

        // Configuração do Bottom Sheet
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        bottomSheetBehavior.isDraggable = false

        //enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}