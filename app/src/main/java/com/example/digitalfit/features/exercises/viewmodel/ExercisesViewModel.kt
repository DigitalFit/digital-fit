import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.example.digitalfit.base.BaseViewModel
import com.example.digitalfit.features.exercises.paging.HomeDataSourceFactory
import com.example.digitalfit.features.exercises.paging.HomePageKeyedDataSource
import com.example.digitalfit.features.exercises.repository.HomeRepository
import com.example.digitalfit.features.exercises.usecase.ExercisesUseCase
import com.example.digitalfit.modelApi.Result
import com.example.digitalfit.utils.ConstantsApp.Home.PAGE_SIZE
import kotlinx.coroutines.launch

class ExercisesViewModel : BaseViewModel() {

    var moviesPagedList: LiveData<PagedList<com.example.digitalfit.modelApi.Result>>? = null
    private var watchMoviesLiveDataSource: LiveData<PageKeyedDataSource<Int, Result>>? = null

    private val exercisesUseCase = ExercisesUseCase()
    private val homeRepository = HomeRepository()

    init {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(PAGE_SIZE).build()


        val homePageKeyedDataSource = HomePageKeyedDataSource(
            homeUseCase = exercisesUseCase,
            homeRepository = homeRepository
        )
        val homeDataSourceFactory = HomeDataSourceFactory(homePageKeyedDataSource)

        watchMoviesLiveDataSource = homeDataSourceFactory.getLiveDataSource()
        moviesPagedList = LivePagedListBuilder(homeDataSourceFactory, pagedListConfig)
            .build()

    }

    fun getMovieById(id: Int) {
        viewModelScope.launch {
            callApi(
                suspend { exercisesUseCase.getMovieById(id) },
                onSuccess = {
                    it
                }
            )
        }
    }
}




