package com.example.digitalfit.features.workout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitalfit.adapter.WorkoutAdapter
import com.example.digitalfit.databinding.FragmentWorkoutBinding
import com.example.digitalfit.features.workout.viewmodel.WorkoutViewModel
import com.example.digitalfit.model.Workout

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
            ViewModelProvider(this)[WorkoutViewModel::class.java]

        _binding = FragmentWorkoutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvWorkout
        workoutViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val workout1  = Workout(
            name = "treino1",
            quantity = 3,
            duration = 30,
            burn = 120
        )

        val workout2 = Workout(
            name = "treino2",
            quantity = 4,
            duration = 40,
            burn = 140
        )
        val workout3 = Workout(
            name = "treino3",
            quantity = 5,
            duration = 50,
            burn = 150
        )
        val workout4 = Workout(
            name = "treino4",
            quantity = 6,
            duration = 60,
            burn = 160
        )

        val workoutList = listOf(workout1, workout2, workout3, workout4)
        val workoutAdapter = WorkoutAdapter(workoutList = workoutList){

        }

        binding?.let {
            with(it) {
                vgWorkoutRecyclerView.layoutManager = LinearLayoutManager(context)
                vgWorkoutRecyclerView.adapter = workoutAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}