package com.example.recipesproject.recipes.data.local

import com.example.recipesproject.recipes.data.local.dao.RecipeDao
import com.example.recipesproject.recipes.data.model.Recipe

class RecipesLocalDataSource(private val recipeDao: RecipeDao) {

    suspend fun getCachedRecipes(): List<Recipe> {
        return recipeDao.getRecipes()
    }

    suspend fun cacheRecipes(recipes: List<Recipe>) {
        recipeDao.cacheRecipes(recipes)
    }
}