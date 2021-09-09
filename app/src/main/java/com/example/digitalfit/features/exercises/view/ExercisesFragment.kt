package com.example.digitalfit.features.exercises.view

import ExercisesViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitalfit.R
import com.example.digitalfit.adapterAPI.ExerciseAdapterApi
import com.example.digitalfit.base.BaseFragment
import com.example.digitalfit.databinding.FragmentExercisesBinding
import com.example.digitalfit.utils.Command
import com.google.android.material.snackbar.Snackbar

// it = activity
// pode usar viewLifecyclerOwner


class ExercisesFragment : BaseFragment() {


    private var binding: FragmentExercisesBinding? = null
    private lateinit var viewModel: ExercisesViewModel

    override var command: MutableLiveData<Command> = MutableLiveData()


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

            viewModel.getListExercises()
            viewModel.getImageExercises()
            viewModel.getInfoExercises()


            binding?.let {
                with(it) {
                    chAll.setOnClickListener {
                        findNavController().navigate(R.id.action_navigation_exercises_to_bottomSheetFilterFragment)
                    }
                    chMuscleGroups.setOnClickListener {
                        findNavController().navigate(R.id.action_navigation_exercises_to_bottomSheetMusclesFragment)
                    }
                    chEquipments.setOnClickListener {
                        findNavController().navigate(R.id.action_navigation_exercises_to_bottomSheetEquipmentsFragment)
                    }
                    ibAdd.setOnClickListener {
                        findNavController().navigate(R.id.action_navigation_exercises_to_exercisesAddFragment)
                    }

                }
            }

//
        }

    }

    private fun setupObeservables() {
        viewModel.onSuccessListExercises.observe(viewLifecycleOwner, {
            it?.let { exercisesList ->
                val exercisesAdapterApi = ExerciseAdapterApi(
                    exercisesList = exercisesList
                ) { it
                }

                binding?.let {
                    with(it) {
                        vgExerciseRecyclerView.apply {
                            layoutManager = LinearLayoutManager(context)
                            adapter = exercisesAdapterApi
                        }
                    }
                }
            }
        }
        )

        viewModel.onErrorListExercises.observe(viewLifecycleOwner, {
            viewLifecycleOwner
        })

        viewModel.command.observe(viewLifecycleOwner, {
            when (it) {
                is Command.Loading -> {

                }
                is Command.Error -> {
                    binding?.let { bindingNonNull ->
                        Snackbar.make(
                            bindingNonNull.vgExerciseRecyclerView,
                            getString(it.error),
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
        )
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}






