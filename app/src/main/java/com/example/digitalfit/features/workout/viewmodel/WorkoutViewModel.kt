package com.example.digitalfit.features.workout.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digitalfit.base.BaseViewModel
import com.example.digitalfit.features.exercisedetail.usecase.ExerciseDetailUseCase
import com.example.digitalfit.features.workout.usecase.WorkoutUseCase
import com.example.digitalfit.modelDb.ExerciseWithImages
import com.example.digitalfit.modelDb.WorkoutDb
import kotlinx.coroutines.launch

class WorkoutViewModel(
    application: Application
) : BaseViewModel(application){

    private val workoutUseCase = WorkoutUseCase(getApplication<Application>())

    private val _onSuccessWorkoutFromDb: MutableLiveData<List<WorkoutDb>> =
        MutableLiveData()
    val onSuccessWorkoutFromDb: LiveData<List<WorkoutDb>>
        get() = _onSuccessWorkoutFromDb


    fun getWorkoutFromDb() {
        viewModelScope.launch {
            val workoutList = workoutUseCase.getWorkoutFromDb()
            _onSuccessWorkoutFromDb.postValue(workoutList)
        }
    }

    fun delete(workout: WorkoutDb) {
        viewModelScope.launch() {
            workoutUseCase.deleteWorkoutFromDb(workout)

        }
    }
}
