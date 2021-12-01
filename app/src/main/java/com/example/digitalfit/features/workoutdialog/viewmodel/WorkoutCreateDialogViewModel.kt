package com.example.digitalfit.features.workoutdialog.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.digitalfit.base.BaseViewModel
import com.example.digitalfit.dataBase.WorkoutDao
import com.example.digitalfit.features.workout.usecase.WorkoutUseCase
import com.example.digitalfit.features.workoutdialog.usecase.WorkoutCreateDialogUseCase
import com.example.digitalfit.modelDb.WorkoutDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class WorkoutCreateDialogViewModel(
    application: Application
) : BaseViewModel(application) {

    private val workoutCreateDialogUseCase = WorkoutCreateDialogUseCase(getApplication<Application>())

    private val _onSuccessWorkoutDialogFromDb: MutableLiveData<WorkoutDb> =
        MutableLiveData()
    val onSuccessWorkoutDialogFromDb: LiveData<WorkoutDb>?
        get() = _onSuccessWorkoutDialogFromDb


    fun getWorkoutByIdFromDb(id: Long): LiveData<WorkoutDb> {
        viewModelScope.launch {
            val workout = workoutCreateDialogUseCase.getWorkoutByIdFromDb(id)
            _onSuccessWorkoutDialogFromDb.postValue(workout)
        }
        return _onSuccessWorkoutDialogFromDb
    }

    fun addData(
        id: Long,
        name: String,
        description: String,
    ) {
        val workout = WorkoutDb(id, name, description)

        viewModelScope.launch {
            workoutCreateDialogUseCase.addData(workout)
        }
    }

//    fun getWorkoutByIdFromDb(id: Int): LiveData<WorkoutDb> {
//        viewModelScope.launch {
//            var workout = workoutCreateDialogUseCase.getWorkoutByIdFromDb(id)
//            return _onSuccessWorkoutDialogFromDb ?: liveData {
//                emit(workoutCreateDialogUseCase.getWorkoutByIdFromDb(id))
//            }.also {
//                _onSuccessWorkoutDialogFromDb = it
//            }
//        }
//
//    }


}