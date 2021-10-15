package com.example.digitalfit.features.exercisedetail.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.digitalfit.base.BaseViewModel
import com.example.digitalfit.features.exercisedetail.usecase.ExerciseDetailUseCase
import com.example.digitalfit.modelDb.*
import kotlinx.coroutines.launch

class ExerciseDetailViewModel(
    application: Application
) : BaseViewModel(application) {

    private val exerciseDetailUseCase = ExerciseDetailUseCase(getApplication<Application>())

//    private val _onSuccessExerciseById: MutableLiveData<ResultInfo> = MutableLiveData()
//    val onSuccessExerciseById: LiveData<ResultInfo>
//        get() = _onSuccessExerciseById

    private val _onSuccessExerciseWithImagesFromDbById: MutableLiveData<ExerciseWithImages> =
        MutableLiveData()
    val onSuccessExerciseWithImagesFromDbById: LiveData<ExerciseWithImages>
        get() = _onSuccessExerciseWithImagesFromDbById

    private val _onSuccessExerciseWithMusclesFromDbById: MutableLiveData<List<ExerciseWithMuscle>> =
        MutableLiveData()
    val onSuccessExerciseWithMusclesFromDbById: LiveData<List<ExerciseWithMuscle>>
        get() = _onSuccessExerciseWithMusclesFromDbById

    private val _onSuccessExerciseWithMusclesSecondaryFromDbById: MutableLiveData<List<ExerciseWithMusclesSecondary>> =
        MutableLiveData()
    val onSuccessExerciseWithMusclesSecondaryFromDbById: LiveData<List<ExerciseWithMusclesSecondary>>
        get() = _onSuccessExerciseWithMusclesSecondaryFromDbById


//    fun getExerciseById(exerciseId: Int) {
//        viewModelScope.launch {
//            callApi(
//                suspend { exerciseDetailUseCase.getExerciseById(exerciseId) },
//                onSuccess = {
//                    _onSuccessExerciseById.postValue(it as? ResultInfo)
//                }
//            )
//        }
//    }

    fun getExerciseWithImagesFromDbById(exerciseId: Int) {
        viewModelScope.launch {
            val exerciseWithImagesFromDb =
                exerciseDetailUseCase.getExercisesWithImagesFromDbById(exerciseId)
            _onSuccessExerciseWithImagesFromDbById.postValue(exerciseWithImagesFromDb)
        }
    }

    fun getExerciseWithMusclesFromDbById(exerciseId: Int) {
        viewModelScope.launch {
            val exerciseWithMusclesFromDb = exerciseDetailUseCase.getExercisesWithMusclesFromDbById(exerciseId)
            _onSuccessExerciseWithMusclesFromDbById.postValue(exerciseWithMusclesFromDb)
        }
    }

    fun getExerciseWithMusclesSecondaryFromDbById(exerciseId: Int) {
        viewModelScope.launch {
            val exerciseWithMusclesSecondaryFromDb = exerciseDetailUseCase.getExercisesWithMusclesSecondaryFromDbById(exerciseId)
            _onSuccessExerciseWithMusclesSecondaryFromDbById.postValue(exerciseWithMusclesSecondaryFromDb)
        }
    }

}

