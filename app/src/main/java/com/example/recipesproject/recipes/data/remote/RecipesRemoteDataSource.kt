package com.example.recipesproject.recipes.data.remote

import com.example.recipesproject.base.datasource.BaseRemoteDataSource
import com.example.recipesproject.util.ApiResponse
import com.example.recipesproject.recipes.data.model.RecipesResponse
import com.example.recipesproject.retrofit.RecipesApi

class RecipesRemoteDataSource(private val recipesApi: RecipesApi): BaseRemoteDataSource() {

    suspend fun getRecipes(): ApiResponse<RecipesResponse> {
        return getResponse { recipesApi.searchRecipe() }
    }
}