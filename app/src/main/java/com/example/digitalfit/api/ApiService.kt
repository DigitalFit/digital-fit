package com.example.digitalfit.api

import androidx.viewbinding.BuildConfig
import com.example.digitalfit.utils.ConstantsApp.Api.API_TOKEN
import com.example.digitalfit.utils.ConstantsApp.Api.API_TOKEN_KEY
import com.example.digitalfit.utils.ConstantsApp.Api.QUERY_PARAM_LANGUAGE_KEY
import com.example.digitalfit.utils.ConstantsApp.Api.QUERY_PARAM_LANGUAGE_VALUE
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiService {

    val wgerApi: WGERApi = getWGERApiClient().create(WGERApi::class.java)

    fun getWGERApiClient(): Retrofit {
        return Retrofit.Builder()
            //.baseUrl(BuildConfig.BASE_URL)
            .baseUrl("https://wger.de/api/v2/")
            .client(getInterceptorClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getInterceptorClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()

            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


        val interceptor = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
//            .addInterceptor { chain ->
//                val url = chain.request().url.newBuilder()
//                    .addQueryParameter(QUERY_PARAM_LANGUAGE_KEY, QUERY_PARAM_LANGUAGE_VALUE)
//                    .build()
//                val newRequest = chain.request().newBuilder().url(url).build()
//                chain.proceed(newRequest)
//            }
            .addInterceptor { chain ->
                val headers = chain.request().newBuilder()
                    .addHeader(API_TOKEN_KEY, "Token $API_TOKEN")
                val newRequest = headers.build()
                chain.proceed(newRequest)
            }
        return interceptor.build()
    }
}