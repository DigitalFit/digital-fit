package com.example.digitalfit.api

import com.example.digitalfit.modelApi.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HEAD
import retrofit2.http.Path
import retrofit2.http.Query

interface WGERApi {

    //@HEAD("Authorization: Token e3d6c9c869a54578e57d9a9f951c6aff31d7a5e9")
    @GET("exercise/")
    suspend fun getListExercises(): Response<ListExercises>

    @GET("exercise/{exercise_id}")
    suspend fun getExerciseById(
        @Path("exercise_id") exerciseId : Int
    ): Response<ListExercises>

    @GET("exerciseimage/")
    suspend fun getImageExercises(): Response<ImageExercises>

    @GET("exerciseinfo/?language=2")
    suspend fun getInfoExercises(): Response<InfoExercises>

    @GET("exercisecategory/")
    suspend fun getCategoryExercises(): Response<CategoryExercises>

    @GET("exercisecomment/")
    suspend fun getCommentExercises(): Response<CommentExercises>







}


