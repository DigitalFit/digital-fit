package com.example.digitalfit.features.exercisedetail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.digitalfit.base.BaseViewModel
import com.example.digitalfit.features.exercisedetail.usecase.ExerciseDetailUseCase
import com.example.digitalfit.modelApi.ResultInfo
import kotlinx.coroutines.launch

class ExerciseDetailViewModel: BaseViewModel() {

    private val exerciseDetailUseCase = ExerciseDetailUseCase()

    private val _onSuccessExerciseById: MutableLiveData<ResultInfo> = MutableLiveData()
    val onSuccessExerciseById: LiveData<ResultInfo>
        get() = _onSuccessExerciseById


    fun getExerciseById(exerciseId: Int) {
        viewModelScope.launch {
            callApi(
                suspend { exerciseDetailUseCase.getExerciseById(exerciseId) },
                onSuccess = {
                    _onSuccessExerciseById.postValue(it as? ResultInfo)
                }
            )
        }
    }

}