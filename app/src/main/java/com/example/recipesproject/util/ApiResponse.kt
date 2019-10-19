package com.example.recipesproject.util

sealed class ApiResponse<T> {
    data class Success<T> (val data: T): ApiResponse<T>()
    data class Error<T>(val errorMessage: String): ApiResponse<T>()
}