import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.digitalfit.base.BaseViewModel
import com.example.digitalfit.features.exercises.usecase.ExercisesUseCase
import com.example.digitalfit.modelApi.ImageExercises
import com.example.digitalfit.modelApi.InfoExercises
import com.example.digitalfit.modelApi.Result
import kotlinx.coroutines.launch

class ExercisesViewModel : BaseViewModel() {


    private val exercisesUseCase = ExercisesUseCase()

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

    private val _onSuccessInfoExercises: MutableLiveData<InfoExercises> =
        MutableLiveData()

    val onSuccessInfoExercises: MutableLiveData<InfoExercises>
        get() = _onSuccessInfoExercises

    private val _onErrorInfoExercises: MutableLiveData<Int> =
        MutableLiveData()

    val onErrorInfoExercises: LiveData<Int>
        get() = _onErrorInfoExercises

    fun getListExercises() {
        //Scope = Criar nova trade
        viewModelScope.launch {
            callApi(
                suspend { exercisesUseCase.getListExercises() },
                onSuccess = {
                    val result = it as? List<*>
                    _onSuccessListExercises.postValue(
                        result?.filterIsInstance<Result>()
                    )
                }
            )
        }
    }


    fun getImageExercises() {
        viewModelScope.launch {
            callApi(
                suspend { exercisesUseCase.getImageExercises() },
                onSuccess = {
                    _onSuccessImageExercises.postValue(
                        it as? ImageExercises
                    )
                }
            )
        }
    }

    fun getInfoExercises() {
        viewModelScope.launch {
            callApi(
                suspend { exercisesUseCase.getInfoExercises() },
                onSuccess = {
                    _onSuccessInfoExercises.postValue(
                        it as? InfoExercises
                    )

                }
            )
        }
    }



}








