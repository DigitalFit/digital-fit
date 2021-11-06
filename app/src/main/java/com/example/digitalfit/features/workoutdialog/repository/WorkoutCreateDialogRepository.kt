package com.example.digitalfit.features.workoutdialog.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.digitalfit.base.BaseRepository
import com.example.digitalfit.dataBase.DigitalFitDataBase
import com.example.digitalfit.modelDb.WorkoutDb
import kotlinx.coroutines.CoroutineScope

class WorkoutCreateDialogRepository(
    val application: Application
) : BaseRepository() {

    suspend fun addData(workout: WorkoutDb) {
            var actualId = workout.workoutId

            if (actualId > 0) {
                update(workout)
            } else {
                insert(workout)
            }

        }

    suspend fun insert(workout: WorkoutDb){
        val workoutDao = DigitalFitDataBase.getDatabase(application).workoutDao()
        workoutDao.insert(workout)
    }

    suspend fun update(workout: WorkoutDb){
        val workoutDao = DigitalFitDataBase.getDatabase(application).workoutDao()
        workoutDao.update(workout)
    }

    suspend fun getWorkoutByIdFromDb(id: Long): WorkoutDb {
        val workoutDao = DigitalFitDataBase.getDatabase(application).workoutDao()
        return workoutDao.getWorkoutByIdFromDb(id)
    }

//    fun getWorkoutByIdFromDb(id: Int): WorkoutDb {
//        return _onSuccessWorkoutDialogFromDb ?: liveData {
//            emit(donutDao.get(id))
//        }.also {
//            donutLiveData = it
//        }
//    }
}