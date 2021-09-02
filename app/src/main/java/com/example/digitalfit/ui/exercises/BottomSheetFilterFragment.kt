package com.example.digitalfit.ui.exercises

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.digitalfit.R
import com.example.digitalfit.databinding.FragmentBottomSheetFilterBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFilterFragment : BottomSheetDialogFragment() {

    private var binding: FragmentBottomSheetFilterBinding? = null
    
        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       
            binding = FragmentBottomSheetFilterBinding.inflate(inflater, container, false)
            return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding?.cbEx1?.setOnCheckedChangeListener { _, isChecked ->

            if(isChecked){
                binding?.cbEx2?.isChecked = true
                binding?.cbEx3?.isChecked = true
                binding?.cbEx4?.isChecked = true
            }else{
                binding?.cbEx2?.isChecked = false
                binding?.cbEx3?.isChecked = false
                binding?.cbEx4?.isChecked = false
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}