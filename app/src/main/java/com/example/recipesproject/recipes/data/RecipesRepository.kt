package com.example.recipesproject.recipes.data

import com.example.recipesproject.recipes.data.model.Recipe
import com.example.recipesproject.recipes.data.local.RecipesLocalDataSource
import com.example.recipesproject.recipes.data.remote.RecipesRemoteDataSource
import com.example.recipesproject.util.ApiResponse
import com.example.recipesproject.util.Resource

class RecipesRepository(private val recipesRemoteDataSource: RecipesRemoteDataSource,
                        private val recipesLocalDataSource: RecipesLocalDataSource) :
    IRecipesRepository {

    override suspend fun getRecipes(): Resource<List<Recipe>> {
        return when (val response = recipesRemoteDataSource.getRecipes()) {
            is ApiResponse.Success -> {
                val recipesList = response.data.recipes
                if (recipesList != recipesLocalDataSource.getCachedRecipes()) {
                    recipesLocalDataSource.cacheRecipes(recipesList)
                }
                Resource.Success(recipesList)
            }
            is ApiResponse.Error -> Resource.Error(response.errorMessage, recipesLocalDataSource.getCachedRecipes())
        }
    }
}