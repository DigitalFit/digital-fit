package com.example.digitalfit.features.workout.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.digitalfit.base.BaseRepository
import com.example.digitalfit.dataBase.DigitalFitDataBase
import com.example.digitalfit.modelDb.ExerciseWithImages
import com.example.digitalfit.modelDb.WorkoutDb

class WorkoutRepository(
    val application: Application
) : BaseRepository() {

    suspend fun getWorkoutFromDb(): List<WorkoutDb> {
        val workoutDao = DigitalFitDataBase.getDatabase(application).workoutDao()
        return workoutDao.getAllWorkouts()
    }

    suspend fun deleteWorkoutFromDb(workout: WorkoutDb){
        val workoutDao = DigitalFitDataBase.getDatabase(application).workoutDao()
        workoutDao.deleteExerciseList(workout.workoutId)
        workoutDao.delete(workout)
    }

    suspend fun searchWorkoutsByName(name: String?): List<WorkoutDb> {
        val workoutDao = DigitalFitDataBase.getDatabase(application).workoutDao()
        return workoutDao.searchWorkoutsByName(name)
    }
}