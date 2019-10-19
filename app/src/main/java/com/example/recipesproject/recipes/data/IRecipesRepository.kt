package com.example.recipesproject.recipes.data

import com.example.recipesproject.recipes.data.model.Recipe
import com.example.recipesproject.util.Resource

interface IRecipesRepository {

    suspend fun getRecipes(): Resource<List<Recipe>>
}