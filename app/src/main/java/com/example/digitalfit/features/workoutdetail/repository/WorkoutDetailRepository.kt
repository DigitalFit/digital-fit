package com.example.digitalfit.features.workoutdetail.repository

import android.app.Application
import com.example.digitalfit.base.BaseRepository
import com.example.digitalfit.dataBase.DigitalFitDataBase
import com.example.digitalfit.modelDb.*

class WorkoutDetailRepository(
    private val application: Application
) : BaseRepository()  {
    suspend fun getExerciseListFromWorkout(id: Long): List<ExerciseWithImages> {
        val exerciseWorkoutCrossRefDao = DigitalFitDataBase.getDatabase(application).exerciseWorkoutDao()
        return exerciseWorkoutCrossRefDao.getWorkoutWithExerciseById(id)
    }

    suspend fun getWorkoutFromDbById(id: Long): WorkoutDb {
        val workoutDao = DigitalFitDataBase.getDatabase(application).workoutDao()
        return workoutDao.getWorkoutByIdFromDb(id)
    }

    suspend fun deleteExerciseFromWorkout(exerciseWorkout: ExerciseWorkoutCrossRef) {
        val exerciseWorkoutCrossRefDao = DigitalFitDataBase.getDatabase(application).exerciseWorkoutDao()
        exerciseWorkoutCrossRefDao.delete(exerciseWorkout)
    }


}