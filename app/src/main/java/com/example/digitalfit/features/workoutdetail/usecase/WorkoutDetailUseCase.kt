package com.example.digitalfit.features.workoutdetail.usecase

import android.app.Application
import com.example.digitalfit.features.workoutdetail.repository.WorkoutDetailRepository
import com.example.digitalfit.modelDb.ExerciseWithImages
import com.example.digitalfit.modelDb.ExerciseWorkoutCrossRef
import com.example.digitalfit.modelDb.WorkoutDb

class WorkoutDetailUseCase(
    application: Application
) {
    private val workoutDetailRepository = WorkoutDetailRepository(application)

    suspend fun getExerciseListFromWorkout(id: Long): List<ExerciseWithImages> {
        return workoutDetailRepository.getExerciseListFromWorkout(id)

    }

    suspend fun getWorkoutFromDbById(id: Long): WorkoutDb {
        return workoutDetailRepository.getWorkoutFromDbById(id)
    }

    suspend fun deleteExerciseFromWorkout(exerciseWorkout: ExerciseWorkoutCrossRef) {
        workoutDetailRepository.deleteExerciseFromWorkout(exerciseWorkout)
    }


}