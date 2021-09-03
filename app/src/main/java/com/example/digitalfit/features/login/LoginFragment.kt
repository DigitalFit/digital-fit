package com.example.digitalfit.features.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.digitalfit.R
import com.example.digitalfit.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {


    private var binding: FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btEmail?.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_loginEmailFragment)
        }

        binding?.btGoogle?.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_loginGoogleFragment)

        }

        binding?.btRegister?.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }



    }



    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}