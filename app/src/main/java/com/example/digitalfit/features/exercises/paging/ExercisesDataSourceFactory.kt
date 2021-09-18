package com.example.digitalfit.features.exercises.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.example.digitalfit.modelApi.ResultInfo

class ExercisesDataSourceFactory(
    private val wgerDataSource: ExercisesPageKeyedDataSource
): DataSource.Factory<Int, ResultInfo>() {

    private val wgerLiveDataSource = MutableLiveData<PageKeyedDataSource<Int, ResultInfo>>()

    override fun create(): DataSource<Int, ResultInfo> {
        wgerLiveDataSource.postValue(wgerDataSource)
        return wgerDataSource
    }

    fun getLiveDataSource() : MutableLiveData<PageKeyedDataSource<Int, ResultInfo>> {
        return wgerLiveDataSource
    }
}