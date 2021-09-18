package com.example.digitalfit.features.exercises.paging

import androidx.paging.PageKeyedDataSource
import com.example.digitalfit.features.exercises.repository.ExercisesRepository
import com.example.digitalfit.features.exercises.usecase.ExercisesUseCase
import com.example.digitalfit.modelApi.InfoExercises
import com.example.digitalfit.modelApi.ResultInfo
import com.example.digitalfit.utils.ConstantsApp.Exercise.FIRST_PAGE
import com.example.digitalfit.utils.ResponseApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ExercisesPageKeyedDataSource(
    private val exercisesRepository: ExercisesRepository,
    private val exercisesUseCase: ExercisesUseCase
) : PageKeyedDataSource<Int, ResultInfo>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ResultInfo>
    ) {
        CoroutineScope(IO).launch {
            val exercises: List<ResultInfo> = callExercisesApi(FIRST_PAGE)
            callback.onResult(exercises, null, FIRST_PAGE + 20)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ResultInfo>) {
        loadData(params.key, params.key -20, callback)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ResultInfo>) {
        loadData(params.key, params.key + 20, callback)
    }

    private fun loadData(page: Int, nextPage: Int, callback: LoadCallback<Int, ResultInfo>) {
        CoroutineScope(IO).launch {
            val exercises: List<ResultInfo> = callExercisesApi(page)
            callback.onResult(exercises, nextPage)
        }
    }

    private suspend fun callExercisesApi(page: Int): List<ResultInfo> {
        return when (
            val responseApi = exercisesRepository.getInfoExercises(page)
        ) {
            is ResponseApi.Success -> {
                val list = responseApi.data as? InfoExercises
                exercisesUseCase.setupExercisesList(list)
            }
            is ResponseApi.Error -> {
                listOf()
            }
        }
   }
    
}