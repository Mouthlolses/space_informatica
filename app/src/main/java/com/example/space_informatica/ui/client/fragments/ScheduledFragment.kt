package com.example.space_informatica.ui.client.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.space_informatica.databinding.ScheduledFragmentBinding

class ScheduledFragment : Fragment() {

    private var _binding: ScheduledFragmentBinding? = null
    private val binding get() = _binding!!
    private var categoria: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = ScheduledFragmentBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}