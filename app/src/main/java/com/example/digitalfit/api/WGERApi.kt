package com.example.digitalfit.api

import com.example.digitalfit.modelApi.Exercise
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WGERApi {

    @GET("api/v2/exercise/")
    suspend fun getExercicios(
        @Query("page") page: Int
    ): Response<Exercise>



}


