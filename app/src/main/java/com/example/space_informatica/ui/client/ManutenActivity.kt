package com.example.space_informatica.ui.client

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.space_informatica.R
import com.example.space_informatica.databinding.ActivityManutenBinding
import com.example.space_informatica.ui.client.fragments.RequestFragment
import com.example.space_informatica.ui.client.fragments.ScheduledFragment

class ManutenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityManutenBinding
    private lateinit var btnScheduled: Button
    private lateinit var btnRequest: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        binding = ActivityManutenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        btnScheduled = binding.buttonProgramada
        btnRequest = binding.buttonSolicitada


        btnScheduled.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_content, ScheduledFragment())
                .commit()
        }

        btnRequest.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_content, RequestFragment())
                .commit()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}