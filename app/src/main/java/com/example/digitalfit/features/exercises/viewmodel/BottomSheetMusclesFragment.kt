git status
package com.example.digitalfit.features.exercises.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.digitalfit.R
import com.example.digitalfit.databinding.FragmentBottomSheetMusclesBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetMusclesFragment : BottomSheetDialogFragment() {

    private var binding: FragmentBottomSheetMusclesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetMusclesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.cbMuscleGroup1?.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                binding?.cbMuscleGroup2?.isChecked = true
                binding?.cbMuscleGroup3?.isChecked = true
                binding?.cbMuscleGroup4?.isChecked = true
            } else {
                binding?.cbMuscleGroup2?.isChecked = false
                binding?.cbMuscleGroup3?.isChecked = false
                binding?.cbMuscleGroup4?.isChecked = false
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

