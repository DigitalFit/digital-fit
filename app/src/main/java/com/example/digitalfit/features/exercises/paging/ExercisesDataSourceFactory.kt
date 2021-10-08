package com.example.digitalfit.features.exercises.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.example.digitalfit.modelApi.ResultInfo
import com.example.digitalfit.modelDb.ExerciseWithImages

class ExercisesDataSourceFactory(
    private val wgerDataSource: ExercisesPageKeyedDataSource
): DataSource.Factory<Int, ExerciseWithImages>() {

    private val wgerLiveDataSource = MutableLiveData<PageKeyedDataSource<Int, ExerciseWithImages>>()

    override fun create(): DataSource<Int, ExerciseWithImages> {
        wgerLiveDataSource.postValue(wgerDataSource)
        return wgerDataSource
    }

    fun getLiveDataSource() : MutableLiveData<PageKeyedDataSource<Int, ExerciseWithImages>> {
        return wgerLiveDataSource
    }
}