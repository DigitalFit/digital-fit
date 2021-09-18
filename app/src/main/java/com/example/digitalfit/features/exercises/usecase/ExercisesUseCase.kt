package com.example.digitalfit.features.exercises.usecase


import com.example.digitalfit.features.exercises.repository.ExercisesRepository
import com.example.digitalfit.modelApi.InfoExercises
import com.example.digitalfit.modelApi.ListExercises
import com.example.digitalfit.modelApi.ResultInfo
import com.example.digitalfit.utils.ConstantsApp.Exercise.FIRST_PAGE
import com.example.digitalfit.utils.ResponseApi


class ExercisesUseCase {

    private val exercisesRepository = ExercisesRepository()


//    suspend fun getListExercises(): ResponseApi {
//        return when (val responseApi = exercisesRepository.getListExercises()) {
//            is ResponseApi.Success -> {
//                val data = responseApi.data as? ListExercises
//                val result = data?.results
//                ResponseApi.Success(result)
//            }
//            is ResponseApi.Error -> {
//                responseApi
//            }
//        }
//    }

//    suspend fun getImageExercises(): ResponseApi {
//        return exercisesRepository.getImageExercises()
//
//
//    }

    suspend fun getInfoExercises(): ResponseApi {
        return when (val responseApi = exercisesRepository.getInfoExercises(FIRST_PAGE)) {
            is ResponseApi.Success -> {
                val data = responseApi.data as? InfoExercises
                val result = data?.results
                ResponseApi.Success(result)
            }
            is ResponseApi.Error -> {
                responseApi
            }
        }
    }

//    suspend fun getCategoryExercises(): ResponseApi {
//        return exercisesRepository.getCategoryExercises()
//    }
//
//    suspend fun getCommentExercises(): ResponseApi {
//        return exercisesRepository.getCommentExercises()
//    }

    suspend fun getExerciseById(id: Int) = exercisesRepository.getExerciseById(id)


    fun setupExercisesList(list: InfoExercises?): List<ResultInfo> {
        return list?.results ?: listOf()
    }

}









