package com.example.digitalfit.features.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.digitalfit.databinding.FragmentRecoverPasswordBinding

class RecoverPasswordFragment : Fragment() {

    private var binding: FragmentRecoverPasswordBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecoverPasswordBinding.inflate(inflater , container , false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}