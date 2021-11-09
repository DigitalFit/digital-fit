package com.example.digitalfit.features.workoutaddexercise.viewmodel
//
//import android.app.Application
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.viewModelScope
//import com.example.digitalfit.base.BaseViewModel
//import com.example.digitalfit.features.exercises.paging.ExercisesDataSourceFactory
//import com.example.digitalfit.features.exercises.paging.ExercisesPageKeyedDataSource
//import com.example.digitalfit.features.exercises.repository.ExercisesRepository
//import com.example.digitalfit.features.exercises.usecase.ExercisesUseCase
//import com.example.digitalfit.features.workoutaddexercise.repository.WorkoutAddExerciseRepository
//import com.example.digitalfit.features.workoutaddexercise.usecase.WorkoutAddExerciseUseCase
//import com.example.digitalfit.modelApi.*
//import com.example.digitalfit.modelDb.ExerciseWithImages
//import com.example.digitalfit.modelDb.ExerciseWorkoutCrossRef
//import com.example.digitalfit.utils.ConstantsApp
//import kotlinx.coroutines.async
//import kotlinx.coroutines.awaitAll
//import kotlinx.coroutines.launch
//
//class WorkoutAddExerciseViewModel(
//    application: Application
//) : BaseViewModel(application) {
//
//    var exercisesPagedList: LiveData<PagedList<ExerciseWithImages>>? = null
//
//    private var exercisesLiveDataSource: LiveData<PageKeyedDataSource<Int, ExerciseWithImages>>? = null
//
//    private val workoutAddExerciseUseCase = WorkoutAddExerciseUseCase(getApplication())
//    private val workoutAddExerciseRepository = WorkoutAddExerciseRepository(getApplication<Application>())
//
//    init {
//        val pagedListConfig = PagedList.Config.Builder()
//            .setEnablePlaceholders(false)
//            .setPageSize(ConstantsApp.Exercise.PAGE_SIZE)
//            .build()
//
//        val exercisesPageKeyedDataSource = ExercisesPageKeyedDataSource(
//            exercisesUseCase = workoutAddExerciseUseCase,
//            exercisesRepository = workoutAddExerciseRepository
//        )
//
//        val exercisesDataSourceFactory = ExercisesDataSourceFactory(exercisesPageKeyedDataSource)
//
//        exercisesLiveDataSource = exercisesDataSourceFactory.getLiveDataSource()
//        exercisesPagedList = LivePagedListBuilder(exercisesDataSourceFactory, pagedListConfig)
//            .build()
//
//    }
//
//    private val _onSuccessListExercises: MutableLiveData<List<Result>> =
//        MutableLiveData()
//
//    val onSuccessListExercises: LiveData<List<Result>>
//        get() = _onSuccessListExercises
//
//    private val _onErrorListExercises: MutableLiveData<Int> =
//        MutableLiveData()
//
//    val onErrorListExercises: LiveData<Int>
//        get() = _onErrorListExercises
//
//    //
//    private val _onSuccessImageExercises: MutableLiveData<ImageExercises> =
//        MutableLiveData()
//
//    val onSuccessImageExercises: MutableLiveData<ImageExercises>
//        get() = _onSuccessImageExercises
//
//    private val _onErrorImageExercises: MutableLiveData<Int> =
//        MutableLiveData()
//
//    val onErrorImageExercises: LiveData<Int>
//        get() = _onErrorImageExercises
//
//    //
//    private val _onSuccessInfoExercises: MutableLiveData<List<ResultInfo>> =
//        MutableLiveData()
//
//    val onSuccessInfoExercises: MutableLiveData<List<ResultInfo>>
//        get() = _onSuccessInfoExercises
//
//    private val _onErrorInfoExercises: MutableLiveData<Int> =
//        MutableLiveData()
//
//    val onErrorInfoExercises: LiveData<Int>
//        get() = _onErrorInfoExercises
//
//    //
//    private val _onSuccessCategoryExercises: MutableLiveData<CategoryExercises> =
//        MutableLiveData()
//
//    val onSuccessCategoryExercises: MutableLiveData<CategoryExercises>
//        get() = _onSuccessCategoryExercises
//
//    private val _onErrorCategoryExercises: MutableLiveData<Int> =
//        MutableLiveData()
//
//    val onErrorCategoryExercises: LiveData<Int>
//        get() = _onErrorCategoryExercises
//
//    //
//    private val _onSuccessCommentExercises: MutableLiveData<CommentExercises> =
//        MutableLiveData()
//
//    val onSuccessCommentExercises: MutableLiveData<CommentExercises>
//        get() = _onSuccessCommentExercises
//
//    private val _onErrorCommentExercises: MutableLiveData<Int> =
//        MutableLiveData()
//
//    val onErrorCommentExercises: LiveData<Int>
//        get() = _onErrorCommentExercises
//
//    //
//    private val _onSuccessEquipmentExercises: MutableLiveData<EquipmentExercises> =
//        MutableLiveData()
//
//    val onSuccessEquipmentExercises: MutableLiveData<EquipmentExercises>
//        get() = _onSuccessEquipmentExercises
//
//    private val _onErrorEquipmentExercises: MutableLiveData<Int> =
//        MutableLiveData()
//
//    val onErrorEquipmentExercises: LiveData<Int>
//        get() = _onErrorEquipmentExercises
//
//    //
//    private val _onSuccessLanguageExercises: MutableLiveData<LanguageExercises> =
//        MutableLiveData()
//
//    val onSuccessLanguageExercises: MutableLiveData<LanguageExercises>
//        get() = _onSuccessLanguageExercises
//
//    private val _onErrorLanguageExercises: MutableLiveData<Int> =
//        MutableLiveData()
//
//    val onErrorLanguageExercises: LiveData<Int>
//        get() = _onErrorLanguageExercises
//
//    //
//    private val _onSuccessLicenseExercises: MutableLiveData<LicenseExercises> =
//        MutableLiveData()
//
//    val onSuccessLicenseExercises: MutableLiveData<LicenseExercises>
//        get() = _onSuccessLicenseExercises
//
//    private val _onErrorLicenseExercises: MutableLiveData<Int> =
//        MutableLiveData()
//
//    val onErrorLicenseExercises: LiveData<Int>
//        get() = _onErrorLicenseExercises
//
//    //
//    private val _onSuccessMuscleExercises: MutableLiveData<MuscleExercises> =
//        MutableLiveData()
//
//    val onSuccessMuscleExercises: MutableLiveData<MuscleExercises>
//        get() = _onSuccessMuscleExercises
//
//    private val _onErrorMuscleExercises: MutableLiveData<Int> =
//        MutableLiveData()
//
//    val onErrorMuscleExercises: LiveData<Int>
//        get() = _onErrorMuscleExercises
//
//    //
//    private val _onExerciseEntitiesLoaded: MutableLiveData<Boolean> =  MutableLiveData()
//    val onExerciseEntitiesLoaded: LiveData<Boolean>
//        get() = _onExerciseEntitiesLoaded
//
//    private val _onExercisesWithImagesLoadedFromDb: MutableLiveData<List<ExerciseWithImages>> = MutableLiveData()
//    val onExercisesWithImagesLoadedFromDb: LiveData<List<ExerciseWithImages>>
//        get() = _onExercisesWithImagesLoadedFromDb
//
//    //
//    private val _onSuccessSearchExercisesByName: MutableLiveData<List<ExerciseWithImages>> =
//        MutableLiveData()
//    val onSuccessSearchExercisesByName: LiveData<List<ExerciseWithImages>>
//        get() = _onSuccessSearchExercisesByName
//
//    //add exercise in workout list
//    private val _onSuccessAddExerciseInWorkoutList: MutableLiveData<Boolean> =  MutableLiveData()
//    val onSuccessAddExerciseInWorkoutList: LiveData<Boolean>
//        get() = _onSuccessAddExerciseInWorkoutList
//
////    fun getListExercises() {
////        //Scope = Criar nova trade
////        viewModelScope.launch {
////            callApi(
////                suspend { exercisesUseCase.getListExercises() },
////                onSuccess = {
////                    val result = it as? List<*>
////                    _onSuccessListExercises.postValue(
////                        result?.filterIsInstance<Result>()
////                    )
////                }
////            )
////        }
////    }
//
//    fun getExerciseEntities() {
//        viewModelScope.launch {
//
//            val deferreds = listOf(
//                async { exercisesUseCase.getCategoryExercises() },
//                async { exercisesUseCase.getCommentExercises() },
//                async { exercisesUseCase.getEquipmentExercises() },
//                async { exercisesUseCase.getImageExercises() },
//                async { exercisesUseCase.getLanguageExercises() },
//                async { exercisesUseCase.getLicenseExercises() },
//                async { exercisesUseCase.getMuscleExercises() },
//                async { exercisesUseCase.getInfoExercises()}
//            )
//
//            //val info = async { exercisesUseCase.getInfoExercises()}
//
//            if(deferreds.awaitAll().isNotEmpty()){
//                _onExerciseEntitiesLoaded.postValue(true)
//
////                val result = info.await() as? List<*>
////                _onSuccessInfoExercises.postValue(result?.filterIsInstance<ResultInfo>())
//            }
//
//        }
//    }
//
//    fun searchExercisesByName(name: String?) {
//        viewModelScope.launch {
//            val exerciseSearchedList = exercisesUseCase.searchExercisesByName(name)
//            _onSuccessSearchExercisesByName.postValue(exerciseSearchedList)
//        }
//    }
//
//    fun getExercisesWithImagesFromDb(page: Int) {
//        viewModelScope.launch {
//            val exerciseImageList = exercisesUseCase.getExercisesWithImagesFromDb(page)
//            _onExercisesWithImagesLoadedFromDb.postValue(exerciseImageList)
//        }
//    }
//
//    fun getInfoExercises() {
//        viewModelScope.launch {
//            callApi(
//                suspend { exercisesUseCase.getInfoExercises() },
//                onSuccess = {
//                    val result = it as? List<*>
//                    _onSuccessInfoExercises.postValue(
//                        result?.filterIsInstance<ResultInfo>()
//                    )
//
//                }
//            )
//        }
//    }
//
//    fun getCategoryExercises() {
//        viewModelScope.launch {
//            callApi(
//                suspend { exercisesUseCase.getCategoryExercises() },
//                onSuccess = {
//                    _onSuccessCategoryExercises.postValue(
//                        it as? CategoryExercises
//                    )
//
//                }
//            )
//        }
//
//    }
//
//    fun getCommentExercises() {
//        viewModelScope.launch {
//            callApi(
//                suspend { exercisesUseCase.getCommentExercises() },
//                onSuccess = {
//                    _onSuccessCommentExercises.postValue(
//                        it as? CommentExercises
//                    )
//
//                }
//            )
//        }
//    }
//
//    fun getEquipmentExercises() {
//        viewModelScope.launch {
//            callApi(
//                suspend { exercisesUseCase.getEquipmentExercises() },
//                onSuccess = {
//                    _onSuccessEquipmentExercises.postValue(
//                        it as? EquipmentExercises
//                    )
//                }
//            )
//        }
//    }
//
//    fun getImageExercises() {
//        viewModelScope.launch {
//            callApi(
//                suspend { exercisesUseCase.getImageExercises() },
//                onSuccess = {
//                    _onSuccessImageExercises.postValue(
//                        it as? ImageExercises
//                    )
//                }
//            )
//        }
//    }
//
//    fun getLanguageExercises() {
//        viewModelScope.launch {
//            callApi(
//                suspend { exercisesUseCase.getLanguageExercises() },
//                onSuccess = {
//                    _onSuccessLanguageExercises.postValue(
//                        it as? LanguageExercises
//                    )
//                }
//            )
//        }
//    }
//
//    fun getLicenseExercises() {
//        viewModelScope.launch {
//            callApi(
//                suspend { exercisesUseCase.getLicenseExercises() },
//                onSuccess = {
//                    _onSuccessLicenseExercises.postValue(
//                        it as? LicenseExercises
//                    )
//                }
//            )
//        }
//    }
//
//    fun getMuscleExercises() {
//        viewModelScope.launch {
//            callApi(
//                suspend { exercisesUseCase.getMuscleExercises() },
//                onSuccess = {
//                    _onSuccessMuscleExercises.postValue(
//                        it as? MuscleExercises
//                    )
//                }
//            )
//        }
//    }
//
//    fun getExerciseById(id: Int) {
//        viewModelScope.launch {
//            callApi(
//                suspend { exercisesUseCase.getExerciseById(id) },
//                onSuccess = {
//                    it
//                }
//            )
//        }
//    }
//
//    fun addExerciseInWorkoutList(exerciseWorkoutCrossRef: ExerciseWorkoutCrossRef) {
//        viewModelScope.launch {
//            val exerciseAdded = exercisesUseCase.addExerciseInWorkoutList(exerciseWorkoutCrossRef)
//            _onSuccessAddExerciseInWorkoutList.postValue(true)
//
//        }
//    }
//
//}
