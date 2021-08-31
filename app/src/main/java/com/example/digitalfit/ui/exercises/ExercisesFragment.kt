package com.example.digitalfit.ui.exercises

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitalfit.R
import com.example.digitalfit.adapter.ExerciseAdapter
import com.example.digitalfit.databinding.FragmentExercisesBinding
import com.example.digitalfit.model.Exercise

class ExercisesFragment : Fragment() {

    private lateinit var exercisesViewModel: ExercisesViewModel
    private var binding: FragmentExercisesBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        exercisesViewModel =
//            ViewModelProvider(this).get(ExercisesViewModel::class.java)

        binding = FragmentExercisesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val exercise1  = Exercise(
            name = "exercicio1 com nome muito grande",
            avatar = R.drawable.aask,
            icon = R.drawable.favorite_grey_icon
        )

        val exercise2 = Exercise(
            name = "exercicio2",
            avatar = R.drawable.aask,
            icon = R.drawable.favorite_grey_icon
        )
        val exercise3 = Exercise(
            name = "exercicio3",
            avatar = R.drawable.aask,
            icon = R.drawable.favorite_grey_icon
        )
        val exercise4 = Exercise(
            name = "exercicio4",
            avatar = R.drawable.aask,
            icon = R.drawable.favorite_grey_icon
        )
        val exercise5 = Exercise(
            name = "exercicio5",
            avatar = R.drawable.aask,
            icon = R.drawable.favorite_grey_icon
        )

        val exerciseList = listOf(exercise1, exercise2, exercise3, exercise4, exercise5)
        val exerciseAdapter = ExerciseAdapter(exerciseList = exerciseList){

        }
        binding?.let {
            with(it) {
                vgExerciseRecyclerView.layoutManager = LinearLayoutManager(context)
                vgExerciseRecyclerView.adapter = exerciseAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}


