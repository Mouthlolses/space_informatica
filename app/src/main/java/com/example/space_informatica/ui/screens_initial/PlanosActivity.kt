package com.example.space_informatica.ui.screens_initial

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.space_informatica.R
import com.example.space_informatica.databinding.ActivityPlanosBinding
import com.google.android.material.card.MaterialCardView

class PlanosActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityPlanosBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonReturn.setOnClickListener {
            finish()
        }

        binding.cardView.setOnClickListener {
            showDialog()
        }

        binding.cardView2.setOnClickListener {
            showDialog2()
        }

        binding.cardView3.setOnClickListener {
            showDialog3()
        }
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Plano Básico")
        builder.setMessage(
            "\n • Manutenção preventiva realizada a cada 1 ano\n\n" +
                    "• Uma visita para verificação a cada 2 meses\n\n" +
                    "• Atendimento Presencial com prazo de até 48 horas\n\n" +
                    "• Atendimento Remoto em Horário Comercial\n\n" +
                    "• Instalação de Equipamentos c/ carência até 48 horas"
        )
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        builder.create().show()
    }

    private fun showDialog2() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Plano Padrão")
        builder.setMessage(
            "\n • Manutenção preventiva realizada a cada 8 meses\n\n" +
                    "• Uma visita para verificação a cada 1 mês\n\n" +
                    "• Atendimento Presencial com prazo de até 24 horas\n\n" +
                    "• Atendimento Remoto em Horário Comercial\n\n" +
                    "• Instalação de Equipamentos em 24 horas"
        )
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        builder.create().show()
    }

    private fun showDialog3() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Plano Exclusivo")
        builder.setMessage(
            "\n • Manutenção preventiva realizada a cada 6 meses\n\n" +
                    "• Uma visita para verificação a cada 1 mês\n\n" +
                    "• Atendimento Presencial com Prioridade Máxima\n\n" +
                    "• Atendimento Remoto em Horário Comercial\n\n" +
                    "• Suporte a Rede de computadores\n\n" +
                    "• Instalação de Equipamentos com Prioridade Máxima\n\n" +
                    "• Peças inclusas ao consertar equipamentos"

        )
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        builder.create().show()
    }
}