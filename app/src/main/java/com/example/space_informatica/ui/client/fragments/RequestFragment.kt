package com.example.space_informatica.ui.client.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.space_informatica.R
import com.example.space_informatica.databinding.RequestFragmentBinding

class RequestFragment : Fragment() {

    private var _binding: RequestFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RequestFragmentBinding.inflate(
            inflater,
            container,
            false
        )

        binding.extendedFabRequest.setOnClickListener {
            parentFragmentManager.commit {
                replace(
                    R.id.fragment_content,
                    FormRequestFragment()
                )
                addToBackStack(null)
            }
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}