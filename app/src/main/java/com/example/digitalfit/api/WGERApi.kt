package com.example.digitalfit.api

import com.example.digitalfit.modelApi.ImageExercises
import com.example.digitalfit.modelApi.InfoExercises
import com.example.digitalfit.modelApi.ListExercises
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WGERApi {

    @GET("exercise/")
    suspend fun getListExercises(): Response<ListExercises>

    @GET("exerciseimage/")
    suspend fun getImageExercises(): Response<ImageExercises>

    @GET("exerciseinfo/")
    suspend fun getInfoExercises(): Response<InfoExercises>





}


