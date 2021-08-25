package com.example.digitalfit.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.digitalfit.R
import com.example.digitalfit.databinding.FragmentLoginEmailBinding

class LoginEmailFragment : Fragment() {

    private var binding: FragmentLoginEmailBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginEmailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btRecoverPassword?.setOnClickListener {
            findNavController().navigate(R.id.action_loginEmailFragment_to_recoverPasswordFragment)
        }



    binding?.btIniciarSessao?.setOnClickListener {
        findNavController().navigate(R.id.action_loginEmailFragment_to_mainActivity)
    }

}


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}