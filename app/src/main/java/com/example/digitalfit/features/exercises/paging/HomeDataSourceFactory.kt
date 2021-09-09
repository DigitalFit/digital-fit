package com.example.digitalfit.features.exercises.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
//
//class HomeDataSourceFactory(
//    private val wgerDataSource: HomePageKeyedDataSource
//): DataSource.Factory<Int, com.example.digitalfit.modelApi.Result>() {
//
//    private val wgerLiveDataSource = MutableLiveData<PageKeyedDataSource<Int, com.example.digitalfit.modelApi.Result>>()
//    override fun create(): DataSource<Int, com.example.digitalfit.modelApi.Result> {
//        wgerLiveDataSource.postValue(wgerDataSource)
//        return wgerDataSource
//    }
//
//    fun getLiveDataSource() : MutableLiveData<PageKeyedDataSource<Int, com.example.digitalfit.modelApi.Result>> {
//        return wgerLiveDataSource
//    }
//}