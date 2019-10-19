package com.example.recipesproject.retrofit

import com.example.recipesproject.recipes.data.model.RecipesResponse
import retrofit2.Response
import retrofit2.http.GET

interface RecipesApi {

    @GET("api/search")
    suspend fun searchRecipe(): Response<RecipesResponse>
}