package com.example.digitalfit.features.exercises.view

import ExercisesViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitalfit.R
import com.example.digitalfit.adapter.ExerciseAdapter
import com.example.digitalfit.databinding.FragmentExercisesBinding

import com.example.digitalfit.model.Exercise
import com.example.digitalfit.utils.Command
import com.google.android.material.snackbar.Snackbar

class ExercisesFragment : Fragment() {



    private var binding: FragmentExercisesBinding? = null
    private lateinit var viewModel: ExercisesViewModel
    private lateinit var exercisesViewModel: ExercisesViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentExercisesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
             viewModel = ViewModelProvider(it)[ExercisesViewModel::class.java]

            viewModel.command = command

//            setupObservables()
//            setupRecyclerView()

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

//
        }

    }

//    private fun setupRecyclerView() {
//        binding?.vgExerciseRecyclerView?.apply {
//            layoutManager = LinearLayoutManager(this.context)
//            adapter = ExerciseAdapterApi
//        }
//    }

//    private fun setupObservables() {
//        viewModel.moviesPagedList?.observe(viewLifecycleOwner, {
//           ExerciseAdapterApi.submitList(it)
//        })
//
//        viewModel.command.observe(viewLifecycleOwner, {
//            when (it) {
//                is Command.Loading -> {
//
//                }
//                is Command.Error -> {
//                    binding?.let { bindingNonNull ->
//                        Snackbar.make(
//                            bindingNonNull.vgExerciseRecyclerView,
//                            getString(it.error),
//                            Snackbar.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//            }
//        })
//    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    var command: MutableLiveData<Command> = MutableLiveData()
}






