package com.example.digitalfit.features.exercises.viewmodel

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

/*//////////
        val checkedRadioButtonId = binding?.rgFilter?.checkedRadioButtonId // Returns View.NO_ID if nothing is checked.
        binding?.rgFilter?.setOnCheckedChangeListener { group, checkedId ->
            // Responds to child RadioButton checked/unchecked
        }

// To check a radio button
        radioButton.isChecked = true

// To listen for a radio button's checked/unchecked state changes
        radioButton.setOnCheckedChangeListener { buttonView, isChecked
            // Responds to radio button being checked/unchecked
        }
*//////////
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}