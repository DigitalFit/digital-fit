package com.example.digitalfit.features.exercisedetail.usecase

import com.example.digitalfit.features.exercisedetail.repository.ExerciseDetailRepository
import com.example.digitalfit.modelApi.InfoExercises
import com.example.digitalfit.utils.ResponseApi

class ExerciseDetailUseCase {

    private val exerciseDetailRepository = ExerciseDetailRepository()

    suspend fun getExerciseById(exerciseId: Int): ResponseApi {
        return exerciseDetailRepository.getExerciseById(exerciseId)
    }
}