package com.example.digitalfit.ui.exercises

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.digitalfit.databinding.FragmentExercisesBinding

class ExercisesFragment : Fragment() {

    private lateinit var exercisesViewModel: ExercisesViewModel
    private var _binding: FragmentExercisesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        exercisesViewModel =
            ViewModelProvider(this).get(ExercisesViewModel::class.java)

        _binding = FragmentExercisesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
