package com.example.digitalfit.api

import com.example.digitalfit.modelApi.*
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

    @GET("exercisecategory/")
    suspend fun getCategoryExercises(): Response<CategoryExercises>

    @GET("exercisecomment/")
    suspend fun getCommentExercises(): Response<CommentExercises>







}


