package com.example.digitalfit.features.exercises.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.digitalfit.base.BaseViewModel
import com.example.digitalfit.features.exercises.paging.ExercisesDataSourceFactory
import com.example.digitalfit.features.exercises.paging.ExercisesPageKeyedDataSource
import com.example.digitalfit.features.exercises.repository.ExercisesRepository
import com.example.digitalfit.features.exercises.usecase.ExercisesUseCase
import com.example.digitalfit.modelApi.*
import com.example.digitalfit.modelDb.ExerciseWithImages
import com.example.digitalfit.modelDb.ExerciseWorkoutCrossRef
import com.example.digitalfit.utils.ConstantsApp.Exercise.PAGE_SIZE
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class ExercisesViewModel(
    application: Application
) : BaseViewModel(application) {

    var exercisesPagedList: LiveData<PagedList<ExerciseWithImages>>? = null

    private var exercisesLiveDataSource: LiveData<PageKeyedDataSource<Int, ExerciseWithImages>>? = null

    private val exercisesUseCase = ExercisesUseCase(getApplication())
    private val exerciseRepository = ExercisesRepository(getApplication<Application>())

    init {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(PAGE_SIZE)
            .build()

        val exercisesPageKeyedDataSource = ExercisesPageKeyedDataSource(
            exercisesUseCase = exercisesUseCase,
            exercisesRepository = exerciseRepository
        )

        val exercisesDataSourceFactory = ExercisesDataSourceFactory(exercisesPageKeyedDataSource)

        exercisesLiveDataSource = exercisesDataSourceFactory.getLiveDataSource()
        exercisesPagedList = LivePagedListBuilder(exercisesDataSourceFactory, pagedListConfig)
            .build()

    }

    //
    private val _onExerciseEntitiesLoaded: MutableLiveData<Boolean> =  MutableLiveData()
    val onExerciseEntitiesLoaded: LiveData<Boolean>
        get() = _onExerciseEntitiesLoaded

    //
    private val _onSuccessSearchExercisesByName: MutableLiveData<List<ExerciseWithImages>> =
        MutableLiveData()
    val onSuccessSearchExercisesByName: LiveData<List<ExerciseWithImages>>
        get() = _onSuccessSearchExercisesByName

    //add exercise in workout list
    private val _onSuccessAddExerciseToWorkoutList: MutableLiveData<Boolean> =  MutableLiveData()
    val onSuccessAddExerciseToWorkoutList: LiveData<Boolean>
        get() = _onSuccessAddExerciseToWorkoutList


    fun getExerciseEntities() {
        viewModelScope.launch {

            val deferreds = listOf(
                async { exercisesUseCase.getCategoryExercises() },
                async { exercisesUseCase.getCommentExercises() },
                async { exercisesUseCase.getEquipmentExercises() },
                async { exercisesUseCase.getImageExercises() },
                async { exercisesUseCase.getLanguageExercises() },
                async { exercisesUseCase.getLicenseExercises() },
                async { exercisesUseCase.getMuscleExercises() },
                async { exercisesUseCase.getInfoExercises()}
            )

            if(deferreds.awaitAll().isNotEmpty()){
                _onExerciseEntitiesLoaded.postValue(true)

            }

        }
    }

    fun searchExercisesByName(name: String?) {
        viewModelScope.launch {
            val exerciseSearchedList = exercisesUseCase.searchExercisesByName(name)
            _onSuccessSearchExercisesByName.postValue(exerciseSearchedList)
        }
    }

    fun getExerciseById(id: Int) {
        viewModelScope.launch {
            callApi(
                suspend { exercisesUseCase.getExerciseById(id) },
                onSuccess = {
                    it
                }
            )
        }
    }

    fun addExerciseToWorkoutList(exerciseWorkoutCrossRef: ExerciseWorkoutCrossRef) {
        viewModelScope.launch {
            val exerciseAdded = exercisesUseCase.addExerciseToWorkoutList(exerciseWorkoutCrossRef)
            if(exerciseAdded != -1L){
                _onSuccessAddExerciseToWorkoutList.postValue(true)
            }else{
                _onSuccessAddExerciseToWorkoutList.postValue(false)
            }
        }
    }
}









