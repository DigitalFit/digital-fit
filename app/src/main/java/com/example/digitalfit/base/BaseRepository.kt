package com.example.digitalfit.base

import com.example.digitalfit.R
import com.example.digitalfit.utils.ErrorUtils
import com.example.digitalfit.utils.ResponseApi
import retrofit2.Response

//suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>) = safeApiResult(call)
//
//private suspend fun <T: Any> safeApiResult(call: suspend ()-> Response<T>) : ResponseApi {
//    try {
//        val response = call.invoke()
//
//        return if(response.isSuccessful) {
//            ResponseApi.Success(response.body())
//        } else {
//            val error = ErrorUtils.parseError(response)
//
//            error?.message?.let {  message ->
//                ResponseApi.Error(message)
//            } ?: run {
//                ResponseApi.Error(R.string.error_default)
//            }
//        }
//    } catch (error : Exception) {
//        return ResponseApi.Error(R.string.error_default)
//    }
//}
