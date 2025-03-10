package com.example.space_informatica.ui.client

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.space_informatica.R
import com.example.space_informatica.databinding.ActivityManutenBinding
import com.example.space_informatica.ui.client.fragments.RequestFragment
import com.example.space_informatica.ui.client.fragments.ScheduledFragment


class ManutenActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityManutenBinding.inflate(layoutInflater)
    }
    private lateinit var btnScheduled: Button
    private lateinit var btnRequest: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(binding.root)


        btnScheduled = binding.buttonProgramada
        btnRequest = binding.buttonSolicitada

        btnScheduled.setOnClickListener {
            //Outra maneira para fazer a transição entre fragments
            /*supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_content, ScheduledFragment())
                .commit()*/

            supportFragmentManager.commit {
                //Utilizando KTX do Android Jetpack
                replace<ScheduledFragment>(
                    R.id.fragment_content,
                    //args = Bundle // Posso passar o Bundle como argumento diretamente com o KTX
                )
            }
        }

        btnRequest.setOnClickListener {
            //Utilizando KTX do Android Jetpack
            supportFragmentManager.commit {
                replace<RequestFragment>(
                    R.id.fragment_content,
                    //args = Bundle // Posso passar o Bundle como argumento diretamente com o KTX
                )
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}