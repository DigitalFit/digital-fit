package com.example.digitalfit.features.workoutdetail.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitalfit.adapterAPI.WorkoutAdapterDb
import com.example.digitalfit.adapterAPI.WorkoutExerciseAdapterDb
import com.example.digitalfit.base.BaseFragment
import com.example.digitalfit.databinding.FragmentWorkoutDetailBinding
import com.example.digitalfit.features.workout.view.WorkoutFragmentDirections
import com.example.digitalfit.features.workoutdetail.viewmodel.WorkoutDetailViewModel
import com.example.digitalfit.modelDb.ExerciseWorkoutCrossRef
import com.example.digitalfit.utils.Command

class WorkoutDetailFragment() : BaseFragment() {

    private var binding: FragmentWorkoutDetailBinding? = null

    private lateinit var viewModel: WorkoutDetailViewModel

    private var workoutId: Long = -1

    override var command: MutableLiveData<Command> = MutableLiveData()

    private val workoutExerciseAdapterDb = WorkoutExerciseAdapterDb(
        onDelete = { exercise ->
            val exerciseWorkoutCrossRef = ExerciseWorkoutCrossRef(
                exerciseId = exercise.exercise.exerciseId,
                workoutId = workoutId
            )
            NotificationManagerCompat.from(requireContext()).cancel(exercise.exercise.exerciseId)
            viewModel.delete(exerciseWorkoutCrossRef)

            Handler(Looper.getMainLooper()).postDelayed({
                viewModel.getExerciseListFromWorkout(workoutId)
            }, 200L)

        },
        onDetail = { exercise ->
            findNavController().navigate(
                WorkoutDetailFragmentDirections.actionWorkoutDetailFragmentToExerciseDetailFragment(exercise.exercise.exerciseId)
            )
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val args: WorkoutDetailFragmentArgs by navArgs()
        workoutId = args.itemId

        binding = FragmentWorkoutDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        activity?.let {
            viewModel = ViewModelProvider(it)[WorkoutDetailViewModel::class.java]

            viewModel.command = command

            viewModel.getExerciseListFromWorkout(workoutId)

            viewModel.getWorkoutFromDbById(workoutId)

            setupObservables()
            setupRecyclerView()
        }
    }

    private fun setupObservables(){
        viewModel.onSuccessExerciseListFromWorkout.observe(viewLifecycleOwner, { exercises ->
            workoutExerciseAdapterDb.submitList(exercises)
        })

        viewModel.onSuccessWorkoutFromDbById.observe(viewLifecycleOwner, { workout ->
            binding?.tvWorkoutName?.text = workout.name
        })

        viewModel.command.observe(viewLifecycleOwner, {
            when(it){
                is Command.Loading -> {

                }
                is Command.Error -> {

                }
            }
        })

        binding?.fab?.setOnClickListener { fabView ->
            fabView.findNavController().navigate(
                WorkoutDetailFragmentDirections.actionWorkoutDetailFragmentToWorkoutAddExerciseFragment(workoutId)
            )
        }

        binding?.ibBackIcon?.setOnClickListener {
            activity?.onBackPressed()
        }

    }

    private fun setupRecyclerView() {
        binding?.vgWorkoutDetailRecyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = workoutExerciseAdapterDb
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}