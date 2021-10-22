package com.example.digitalfit.features.workout.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.digitalfit.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class WorkoutCreateDialog: BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_workout_create, container, false)
    }
}