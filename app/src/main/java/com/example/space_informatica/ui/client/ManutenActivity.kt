package com.example.space_informatica.ui.client

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.space_informatica.R
import com.example.space_informatica.databinding.ActivityManutenBinding
import com.example.space_informatica.ui.client.fragments.FragmentManuntenProgramada
import com.example.space_informatica.ui.client.fragments.FragmentManutenSolicitadas

class ManutenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityManutenBinding
    private lateinit var btnProgramadas: Button
    private lateinit var btnSolicitadas: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        binding = ActivityManutenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnProgramadas = findViewById(R.id.btnProgramadas)
        btnSolicitadas = findViewById(R.id.btnSolicitadas)

        val fragmentManutenSolicitadas = FragmentManutenSolicitadas()
        val fragmentManutenProgramadas = FragmentManuntenProgramada()


        btnProgramadas.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_conteudo, fragmentManutenProgramadas)
                .commit()
        }

        btnSolicitadas.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_conteudo, fragmentManutenSolicitadas)
                .commit()
        }


    }
}