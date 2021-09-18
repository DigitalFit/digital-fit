package com.example.digitalfit.features.exercises.repository

import com.example.digitalfit.api.ApiService
import com.example.digitalfit.base.BaseRepository
import com.example.digitalfit.utils.ResponseApi

class ExercisesRepository : BaseRepository() {
    //chamdas de dados


//    suspend fun getListExercises(): ResponseApi {
//        return safeApiCall {
//            ApiService.wgerApi.getListExercises()
//        }
//
//    }
//
//    suspend fun getImageExercises(): ResponseApi {
//        return safeApiCall {
//            ApiService.wgerApi.getImageExercises()
//        }
//
//    }

    suspend fun getInfoExercises(page: Int): ResponseApi {
        return safeApiCall {
            ApiService.wgerApi.getInfoExercises(page)
        }

    }

//    suspend fun getCategoryExercises(): ResponseApi {
//        return  safeApiCall {
//            ApiService.wgerApi.getCategoryExercises()
//        }
//
//    }
//
//    suspend fun getCommentExercises(): ResponseApi {
//        return  safeApiCall {
//            ApiService.wgerApi.getCommentExercises()
//        }
//
//    }

    suspend fun getExerciseById(id: Int): ResponseApi {
        return safeApiCall {
            ApiService.wgerApi.getExerciseById(id)
        }
    }


}




