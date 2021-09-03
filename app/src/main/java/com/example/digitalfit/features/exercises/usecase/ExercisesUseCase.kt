package com.example.digitalfit.features.exercises.usecase

import com.example.digitalfit.features.exercises.repository.HomeRepository
import com.example.digitalfit.modelApi.Exercise
import com.example.digitalfit.modelApi.Result
import com.example.digitalfit.utils.ConstantsApp.Home.FIRST_PAGE
import com.example.digitalfit.utils.ResponseApi


class ExercisesUseCase {

    private val homeRepository = HomeRepository()

    suspend fun getExercises(): ResponseApi {
        return when (val responseApi = homeRepository.getExercises(FIRST_PAGE)) {
            is ResponseApi.Success -> {
                val data = responseApi.data as? Exercise
                val result = data?.results?.map {
                    it
                }
                ResponseApi.Success(result)
            }
            is ResponseApi.Error -> {
                responseApi
            }
        }
    }



    suspend fun getMovieById(id: Int) =
        homeRepository.getMovieById(id)

    fun setupMoviesList(list: Exercise?): List<Result> {
        return list?.results?.map {

            it } ?: listOf()
    }
}


