package com.example.digitalfit.features.exercisedetail.usecase

import android.app.Application
import com.example.digitalfit.features.exercisedetail.repository.ExerciseDetailRepository
import com.example.digitalfit.modelApi.InfoExercises
import com.example.digitalfit.modelApi.ResultInfo
import com.example.digitalfit.modelDb.ExerciseWithImages
import com.example.digitalfit.modelDb.ExerciseWithMuscle
import com.example.digitalfit.modelDb.ExerciseWithMusclesSecondary
import com.example.digitalfit.utils.ConstantsApp
import com.example.digitalfit.utils.ResponseApi

class ExerciseDetailUseCase(
    application: Application
) {

    private val exerciseDetailRepository = ExerciseDetailRepository(application)

    suspend fun getExercisesWithImagesFromDbById(exerciseId: Int) =
        exerciseDetailRepository.getExercisesWithImagesFromDbById(exerciseId)

    suspend fun getExercisesWithMusclesFromDbById(exerciseId: Int) =
        exerciseDetailRepository.getExercisesWithMusclesFromDbById(exerciseId)

    suspend fun getExercisesWithMusclesSecondaryFromDbById(exerciseId: Int) =
        exerciseDetailRepository.getExercisesWithMusclesSecondaryFromDbById(exerciseId)
}