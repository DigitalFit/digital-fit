package com.example.digitalfit.features.exercises.paging

import androidx.paging.PageKeyedDataSource
import com.example.digitalfit.features.exercises.repository.ExercisesRepository
import com.example.digitalfit.features.exercises.usecase.ExercisesUseCase
import com.example.digitalfit.modelApi.ListExercises
import com.example.digitalfit.utils.ConstantsApp.Home.FIRST_PAGE
import com.example.digitalfit.utils.ResponseApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

//class HomePageKeyedDataSource(
//    private val homeRepository: ExercisesRepository,
//    private val homeUseCase: ExercisesUseCase
//) : PageKeyedDataSource<Int, com.example.digitalfit.modelApi.Result>() {
//
//    override fun loadInitial(
//        params: LoadInitialParams<Int>,
//        callback: LoadInitialCallback<Int, com.example.digitalfit.modelApi.Result>
//    ) {
//        CoroutineScope(IO).launch {
//            val movies: List<com.example.digitalfit.modelApi.Result> = callNowPlayingMoviesApi(FIRST_PAGE)
//            callback.onResult(movies, null, FIRST_PAGE + 1)
//        }
//    }
//
//    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, com.example.digitalfit.modelApi.Result>) {
//        loadData(params.key, params.key - 1, callback)
//    }
//
//    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, com.example.digitalfit.modelApi.Result>) {
//        loadData(params.key, params.key + 1, callback)
//    }

//    private fun loadData(page: Int, nextPage: Int, callback: LoadCallback<Int, com.example.digitalfit.modelApi.Result>) {
//        CoroutineScope(IO).launch {
//            val movies: List<com.example.digitalfit.modelApi.Result> = callNowPlayingMoviesApi(page)
//            callback.onResult(movies, nextPage)
//        }
//    }

//    private suspend fun callNowPlayingMoviesApi(page: Int): List<com.example.digitalfit.modelApi.Result> {
//        return when (
//            val response = homeRepository.getExercises(page)
//        ) {
//            is ResponseApi.Success -> {
//                val list = response.data as? ListExercises
//                homeUseCase.setupMoviesList(list)
//            }
//            is ResponseApi.Error -> {
//                listOf()
//            }
//        }
////    }
//}