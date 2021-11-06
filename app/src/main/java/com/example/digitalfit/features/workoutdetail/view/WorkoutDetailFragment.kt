package com.example.digitalfit.features.workoutdetail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitalfit.base.BaseFragment
import com.example.digitalfit.databinding.FragmentWorkoutDetailBinding
import com.example.digitalfit.features.workout.view.WorkoutFragmentDirections
import com.example.digitalfit.features.workoutdetail.viewmodel.WorkoutDetailViewModel
import com.example.digitalfit.utils.Command

class WorkoutDetailFragment() : BaseFragment() {

    private var binding: FragmentWorkoutDetailBinding? = null

    private lateinit var viewModel: WorkoutDetailViewModel

    override var command: MutableLiveData<Command> = MutableLiveData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkoutDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: WorkoutDetailFragmentArgs by navArgs()

        activity?.let {
            viewModel = ViewModelProvider(it)[WorkoutDetailViewModel::class.java]

            viewModel.command = command

            viewModel.getWorkoutFromDbById(args.itemId)

            setupObservables()
            setupRecyclerView()
        }
    }

    private fun setupObservables(){

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
                WorkoutFragmentDirections.actionWorkoutFragmentToWorkoutCreateDialog()
            )
        }

        binding?.ibBackIcon?.setOnClickListener {
            activity?.onBackPressed()
        }

    }

    private fun setupRecyclerView() {
        binding?.vgWorkoutDetailRecyclerView?.apply {
          //  layoutManager = LinearLayoutManager(context)
           // adapter = workoutDetailAdapterDb
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}