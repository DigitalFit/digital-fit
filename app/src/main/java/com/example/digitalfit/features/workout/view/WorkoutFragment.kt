package com.example.digitalfit.features.workout.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitalfit.adapterAPI.WorkoutAdapterDb
import com.example.digitalfit.base.BaseFragment
import com.example.digitalfit.databinding.FragmentWorkoutBinding
import com.example.digitalfit.features.workout.viewmodel.WorkoutViewModel
import com.example.digitalfit.model.Workout
import com.example.digitalfit.utils.Command

interface Refresh{
    fun refresh()
}

class WorkoutFragment() : BaseFragment(), Refresh {

    private var binding: FragmentWorkoutBinding? = null

    private lateinit var viewModel: WorkoutViewModel

    override var command: MutableLiveData<Command> = MutableLiveData()

    private val workoutAdapterDb = WorkoutAdapterDb(
        onEdit = { workout ->
            findNavController().navigate(
                WorkoutFragmentDirections.actionWorkoutFragmentToWorkoutCreateDialog(workout.workoutId)
            )
        },
        onDelete = { workout ->
            NotificationManagerCompat.from(requireContext()).cancel(workout.workoutId.toInt())
            viewModel.delete(workout)
            viewModel.getWorkoutFromDb()
        },
        onDetail = { workout ->
            findNavController().navigate(
                WorkoutFragmentDirections.actionNavigationWorkoutToWorkoutDetailFragment(workout.workoutId)
            )
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkoutBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        activity?.let {
            viewModel = ViewModelProvider(it)[WorkoutViewModel::class.java]

            viewModel.command = command

            viewModel.getWorkoutFromDb()


            setupObservables()
            setupRecyclerView()
        }

    }

    override fun refresh(){
//        Handler(Looper.getMainLooper()).postDelayed({
//            viewModel.getWorkoutFromDb()
//        }, 500L)
        viewModel.getWorkoutFromDb()
    }

    private fun setupObservables() {
        viewModel.onSuccessWorkoutFromDb.observe(viewLifecycleOwner, { workouts ->
            workoutAdapterDb.submitList(workouts)
        })

        binding?.fab?.setOnClickListener { fabView ->
            fabView.findNavController().navigate(
                WorkoutFragmentDirections.actionWorkoutFragmentToWorkoutCreateDialog()
            )
        }
    }

    private fun setupRecyclerView() {
        binding?.vgWorkoutRecyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = workoutAdapterDb
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}