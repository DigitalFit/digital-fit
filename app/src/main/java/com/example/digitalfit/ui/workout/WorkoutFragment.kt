package com.example.digitalfit.ui.workout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.digitalfit.databinding.FragmentWorkoutBinding

class WorkoutFragment : Fragment() {

    private lateinit var workoutViewModel: WorkoutViewModel
    private var _binding: FragmentWorkoutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        workoutViewModel =
            ViewModelProvider(this).get(WorkoutViewModel::class.java)

        _binding = FragmentWorkoutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textWorkout
        workoutViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}