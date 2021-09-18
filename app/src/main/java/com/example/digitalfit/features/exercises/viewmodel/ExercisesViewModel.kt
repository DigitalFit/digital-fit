import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.example.digitalfit.base.BaseViewModel
import com.example.digitalfit.features.exercises.paging.ExercisesDataSourceFactory
import com.example.digitalfit.features.exercises.paging.ExercisesPageKeyedDataSource
import com.example.digitalfit.features.exercises.repository.ExercisesRepository
//import com.example.digitalfit.features.exercises.paging.ExercisesDataSourceFactory
//import com.example.digitalfit.features.exercises.paging.ExercisesPageKeyedDataSource
import com.example.digitalfit.features.exercises.usecase.ExercisesUseCase
import com.example.digitalfit.modelApi.*
import com.example.digitalfit.utils.ConstantsApp.Exercise.PAGE_SIZE
import kotlinx.coroutines.launch

class ExercisesViewModel : BaseViewModel() {

    var exercisesPagedList: LiveData<PagedList<ResultInfo>>? = null
    private var exercisesLiveDataSource: LiveData<PageKeyedDataSource<Int, ResultInfo>>? = null

    private val exercisesUseCase = ExercisesUseCase()
    private val exerciseRepository = ExercisesRepository()

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



    private val _onSuccessListExercises: MutableLiveData<List<Result>> =
        MutableLiveData()

    val onSuccessListExercises: LiveData<List<Result>>
        get() = _onSuccessListExercises

    private val _onErrorListExercises: MutableLiveData<Int> =
        MutableLiveData()

    val onErrorListExercises: LiveData<Int>
        get() = _onErrorListExercises


    private val _onSuccessImageExercises: MutableLiveData<ImageExercises> =
        MutableLiveData()

    val onSuccessImageExercises: MutableLiveData<ImageExercises>
        get() = _onSuccessImageExercises

    private val _onErrorImageExercises: MutableLiveData<Int> =
        MutableLiveData()

    val onErrorImageExercises: LiveData<Int>
        get() = _onErrorImageExercises

    private val _onSuccessInfoExercises: MutableLiveData<List<Exercise>> =
        MutableLiveData()

    val onSuccessInfoExercises: MutableLiveData<List<Exercise>>
        get() = _onSuccessInfoExercises

    private val _onErrorInfoExercises: MutableLiveData<Int> =
        MutableLiveData()

    val onErrorInfoExercises: LiveData<Int>
        get() = _onErrorInfoExercises

    private val _onSuccessCategoryExercises: MutableLiveData<CategoryExercises> =
        MutableLiveData()

    val onSuccessCategoryExercises: MutableLiveData<CategoryExercises>
        get() = _onSuccessCategoryExercises

    private val _onErrorCategoryExercises: MutableLiveData<Int> =
        MutableLiveData()

    val onErrorCategoryExercises: LiveData<Int>
        get() = _onErrorCategoryExercises

    private val _onSuccessCommentExercises: MutableLiveData<CommentExercises> =
        MutableLiveData()

    val onSuccessCommentExercises: MutableLiveData<CommentExercises>
        get() = _onSuccessCommentExercises

    private val _onErrorCommentExercises: MutableLiveData<Int> =
        MutableLiveData()

    val onErrorCommentExercises: LiveData<Int>
        get() = _onErrorCommentExercises




//    fun getListExercises() {
//        //Scope = Criar nova trade
//        viewModelScope.launch {
//            callApi(
//                suspend { exercisesUseCase.getListExercises() },
//                onSuccess = {
//                    val result = it as? List<*>
//                    _onSuccessListExercises.postValue(
//                        result?.filterIsInstance<Result>()
//                    )
//                }
//            )
//        }
//    }


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

    fun getInfoExercises() {
        viewModelScope.launch {
            callApi(
                suspend { exercisesUseCase.getInfoExercises() },
                onSuccess = {
                    val result = it as? List<*>
                    _onSuccessInfoExercises.postValue(
                        result?.filterIsInstance<Exercise>()
                    )

                }
            )
        }
    }

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

}









