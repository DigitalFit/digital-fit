package com.example.digitalfit.features.workoutdialog.usecase

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.digitalfit.features.workout.repository.WorkoutRepository
import com.example.digitalfit.features.workoutdialog.repository.WorkoutCreateDialogRepository
import com.example.digitalfit.modelDb.WorkoutDb

class WorkoutCreateDialogUseCase(
    private val application: Application
) {

    private val workoutCreateDialogRepository = WorkoutCreateDialogRepository(application)

    suspend fun getWorkoutByIdFromDb(id: Long): WorkoutDb {
        return workoutCreateDialogRepository.getWorkoutByIdFromDb(id)
    }

    suspend fun addData(workout: WorkoutDb) {
        workoutCreateDialogRepository.addData(workout)
    }
}