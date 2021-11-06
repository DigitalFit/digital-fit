package com.example.digitalfit.features.workoutdetail.repository

import android.app.Application
import com.example.digitalfit.base.BaseRepository
import com.example.digitalfit.dataBase.DigitalFitDataBase
import com.example.digitalfit.modelDb.WorkoutDb

class WorkoutDetailRepository(
    private val application: Application
) : BaseRepository()  {

    suspend fun getWorkoutFromDbById(id: Long): WorkoutDb {
        val workoutDao = DigitalFitDataBase.getDatabase(application).workoutDao()
        return workoutDao.getWorkoutByIdFromDb(id)
    }
}