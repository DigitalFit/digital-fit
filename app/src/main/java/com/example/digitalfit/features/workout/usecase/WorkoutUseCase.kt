package com.example.digitalfit.features.workout.usecase

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.digitalfit.features.exercises.repository.ExercisesRepository
import com.example.digitalfit.features.workout.repository.WorkoutRepository
import com.example.digitalfit.modelDb.ExerciseWithImages
import com.example.digitalfit.modelDb.WorkoutDb

class WorkoutUseCase(
    private val application: Application
) {

    private val workoutRepository = WorkoutRepository(application)

    suspend fun getWorkoutFromDb(): List<WorkoutDb> {
        return workoutRepository.getWorkoutFromDb()
    }

    suspend fun deleteWorkoutFromDb(workout: WorkoutDb){
        workoutRepository.deleteWorkoutFromDb(workout)
    }
}