package com.example.digitalfit.features.exercises.usecase

import com.example.digitalfit.api.ApiService
import com.example.digitalfit.features.exercises.repository.ExercisesRepository
import com.example.digitalfit.modelApi.ListExercises
import com.example.digitalfit.utils.ResponseApi


class ExercisesUseCase {

    private val exercisesRepository = ExercisesRepository()


    suspend fun getListExercises(): ResponseApi {
        return exercisesRepository.getListExercises()

         }

    suspend fun getImageExercises(): ResponseApi {
         return exercisesRepository.getImageExercises()


    }

    suspend fun getInfoExercises(): ResponseApi {
        return exercisesRepository.getInfoExercises()

    }
}





