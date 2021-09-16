package com.example.digitalfit.features.exercisedetail.repository

import com.example.digitalfit.api.ApiService
import com.example.digitalfit.base.BaseRepository
import com.example.digitalfit.utils.ResponseApi

class ExerciseDetailRepository : BaseRepository(){

    suspend fun getExerciseById(exerciseId: Int): ResponseApi {
        return safeApiCall {
            ApiService.wgerApi.getExerciseById(exerciseId)
        }
    }
}