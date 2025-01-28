package com.example.space_informatica.ui.client

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.compose.material3.Card
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.space_informatica.R
import com.example.space_informatica.databinding.ActivityClientBinding
import com.example.space_informatica.ui.StartScreenActivity

class ClientActivity : AppCompatActivity() {

     private lateinit var binding: ActivityClientBinding
     private lateinit var cardViewManuten: CardView
     private lateinit var cardViewAtendRemote: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        binding = ActivityClientBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Configurar Caminho da opção Manutenções
        cardViewManuten = binding.cardView
        cardViewManuten.setOnClickListener{
            val intent = Intent(this,ManutenActivity::class.java)
            (startActivity(intent))
        }

        cardViewAtendRemote = binding.cardView2
        cardViewAtendRemote.setOnClickListener{
            val intent = Intent(this, AtendRemoteActivity::class.java)
            (startActivity(intent))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}