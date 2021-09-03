package com.example.digitalfit.features.exercises.repository

import com.example.digitalfit.api.ApiService
import com.example.digitalfit.base.BaseRepository

import com.example.digitalfit.utils.ResponseApi

class HomeRepository : BaseRepository() {

    suspend fun getExercises(page: Int): ResponseApi {
        return safeApiCall {
            ApiService.wgerApi.getExercicios(page)
        }
    }

    fun getMovieById(id: Int) {

    }




}