package com.example.recipesproject.base.datasource

import com.example.recipesproject.util.ApiResponse
import retrofit2.Response

open class BaseRemoteDataSource {

    suspend fun <T : Any> getResponse(call: suspend() -> Response<T>): ApiResponse<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                return ApiResponse.Success(response.body()!!)
            }
            return ApiResponse.Error(response.errorBody().toString())
        } catch (e: Exception) {
            e.printStackTrace()
            return ApiResponse.Error("Check network connection")
        }
    }
}