package com.example.digitalfit.api

import com.example.digitalfit.modelApi.*
import retrofit2.Response
import retrofit2.http.*

interface WGERApi {


    @GET("exercise/")
//   @HEAD("Authorization: Token e3d6c9c869a54578e57d9a9f951c6aff31d7a5e9")
//    @Header("e3d6c9c869a54578e57d9a9f951c6aff31d7a5e9")
    suspend fun getListExercises(): Response<ListExercises>


//   @GET("exercise/")
//  suspend fun getListExercises(): Response<ListExercises>


    @GET("exerciseinfo/{exercise_id}")
    suspend fun getExerciseById(
        @Path("exercise_id") exerciseId: Int
    ): Response<ResultInfo>

    @GET("exerciseimage/")
    suspend fun getImageExercises(): Response<ImageExercises>

    @GET("exerciseinfo/?language=2&limit=20")
    suspend fun getInfoExercises(
        @Query("offset") page: Int
    ): Response<InfoExercises>

    @GET("exercisecategory/")
    suspend fun getCategoryExercises(): Response<CategoryExercises>

    @GET("exercisecomment/")
    suspend fun getCommentExercises(): Response<CommentExercises>


}


