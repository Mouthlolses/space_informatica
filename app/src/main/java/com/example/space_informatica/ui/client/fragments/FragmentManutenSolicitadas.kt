package com.example.space_informatica.ui.client.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.space_informatica.databinding.FragmentManutenSolicitadasBinding

class FragmentManutenSolicitadas : Fragment() {

    private lateinit var binding: FragmentManutenSolicitadasBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inicializa o binding do fragmento
        binding = FragmentManutenSolicitadasBinding.inflate(inflater,container,false)


        // Retorna a view inflada
        return binding.root
    }
}