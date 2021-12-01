package com.example.digitalfit.features.workoutdetail.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.digitalfit.base.BaseViewModel
import com.example.digitalfit.features.exercisedetail.usecase.ExerciseDetailUseCase
import com.example.digitalfit.features.workoutdetail.usecase.WorkoutDetailUseCase
import com.example.digitalfit.modelDb.ExerciseWithImages
import com.example.digitalfit.modelDb.ExerciseWorkoutCrossRef
import com.example.digitalfit.modelDb.WorkoutDb
import com.example.digitalfit.modelDb.WorkoutWithExercise
import kotlinx.coroutines.launch

class WorkoutDetailViewModel(
    application: Application
) : BaseViewModel(application){


    private val workoutDetailUseCase = WorkoutDetailUseCase(getApplication<Application>())

    private val _onSuccessExerciseListFromWorkout: MutableLiveData<List<ExerciseWithImages>> =
        MutableLiveData()
    val onSuccessExerciseListFromWorkout: LiveData<List<ExerciseWithImages>>
        get() = _onSuccessExerciseListFromWorkout

    private val _onSuccessWorkoutFromDbById: MutableLiveData<WorkoutDb> =
        MutableLiveData()
    val onSuccessWorkoutFromDbById: LiveData<WorkoutDb>
        get() = _onSuccessWorkoutFromDbById

    fun getExerciseListFromWorkout(id: Long) {
        viewModelScope.launch {
            val exerciseList = workoutDetailUseCase.getExerciseListFromWorkout(id)
            _onSuccessExerciseListFromWorkout.postValue(exerciseList)
        }
    }

    fun getWorkoutFromDbById(id: Long) {
        viewModelScope.launch {
            val workout = workoutDetailUseCase.getWorkoutFromDbById(id)
            _onSuccessWorkoutFromDbById.postValue(workout)
        }
    }

    fun delete(exerciseWorkout: ExerciseWorkoutCrossRef) {
        viewModelScope.launch() {
            workoutDetailUseCase.deleteExerciseFromWorkout(exerciseWorkout)

        }
    }
}