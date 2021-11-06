package com.example.digitalfit.features.workoutdetail.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.digitalfit.base.BaseViewModel
import com.example.digitalfit.features.exercisedetail.usecase.ExerciseDetailUseCase
import com.example.digitalfit.features.workoutdetail.usecase.WorkoutDetailUseCase
import com.example.digitalfit.modelDb.WorkoutDb
import kotlinx.coroutines.launch

class WorkoutDetailViewModel(
    application: Application
) : BaseViewModel(application){

    private val workoutDetailUseCase = WorkoutDetailUseCase(getApplication<Application>())

    private val _onSuccessWorkoutFromDbById: MutableLiveData<WorkoutDb> =
        MutableLiveData()
    val onSuccessWorkoutFromDbById: LiveData<WorkoutDb>
        get() = _onSuccessWorkoutFromDbById

    fun getWorkoutFromDbById(id: Long) {
        viewModelScope.launch {
            val workout = workoutDetailUseCase.getWorkoutFromDbById(id)
            _onSuccessWorkoutFromDbById.postValue(workout)
        }
    }
}