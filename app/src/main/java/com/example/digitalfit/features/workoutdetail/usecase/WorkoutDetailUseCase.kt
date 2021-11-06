package com.example.digitalfit.features.workoutdetail.usecase

import android.app.Application
import com.example.digitalfit.features.exercisedetail.repository.ExerciseDetailRepository
import com.example.digitalfit.features.workoutdetail.repository.WorkoutDetailRepository
import com.example.digitalfit.modelDb.WorkoutDb

class WorkoutDetailUseCase(
    application: Application
) {
    private val workoutDetailRepository = WorkoutDetailRepository(application)

    suspend fun getWorkoutFromDbById(id: Long): WorkoutDb {
        return workoutDetailRepository.getWorkoutFromDbById(id)
    }
}