package com.example.digitalfit.features.workoutdialog.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.digitalfit.Acesso
import com.example.digitalfit.R
import com.example.digitalfit.databinding.DialogWorkoutCreateBinding
import com.example.digitalfit.features.workoutdialog.viewmodel.WorkoutCreateDialogViewModel
import com.example.digitalfit.modelDb.WorkoutDb
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class WorkoutCreateDialog: BottomSheetDialogFragment() {

    private var binding: DialogWorkoutCreateBinding? = null

    private lateinit var viewModel: WorkoutCreateDialogViewModel

    private enum class EditingState {
        NEW_WORKOUT,
        EXISTING_WORKOUT
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogWorkoutCreateBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        activity?.let {
            viewModel = ViewModelProvider(it)[WorkoutCreateDialogViewModel::class.java]
        }


        var workout: WorkoutDb? = null
        val args: WorkoutCreateDialogArgs by navArgs()
        val editingState =
            if (args.itemId > 0) EditingState.EXISTING_WORKOUT
            else EditingState.NEW_WORKOUT

        // If we arrived here with an itemId of >= 0, then we are editing an existing item
        if (editingState == EditingState.EXISTING_WORKOUT) {
            // Request to edit an existing item, whose id was passed in as an argument.
            // Retrieve that item and populate the UI with its details
            viewModel.getWorkoutByIdFromDb(args.itemId).observe(viewLifecycleOwner){ workoutItem ->
                binding?.name?.setText(workoutItem.name)
                binding?.description?.setText(workoutItem.description)
                workout = workoutItem
            }
        }

        // When the user clicks the Done button, use the data here to either update
        // an existing item or create a new one
        binding?.doneButton?.setOnClickListener {
            // Grab these now since the Fragment may go away before the setupNotification
            // lambda below is called


            viewModel.addData(
                workout?.workoutId ?: 0,
                binding?.name?.text.toString(),
                binding?.description?.text.toString(),
            )

            val ac = activity as Acesso
            ac.acessar()

            dismiss()
        }

        // User clicked the Cancel button; just exit the dialog without saving the data
        binding?.cancelButton?.setOnClickListener {
            dismiss()
        }

    }

}