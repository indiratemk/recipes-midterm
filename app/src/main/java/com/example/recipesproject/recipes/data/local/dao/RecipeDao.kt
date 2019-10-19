package com.example.recipesproject.recipes.data.local.dao

import androidx.room.*
import com.example.recipesproject.recipes.data.model.Recipe

@Dao
interface RecipeDao {

    @Query("SELECT * from recipes")
    suspend fun getRecipes(): List<Recipe>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecipe(recipe: Recipe)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecipes(recipes: List<Recipe>)

    @Query("DELETE FROM recipes")
    suspend fun deleteAll()

    @Transaction
    suspend fun cacheRecipes(recipes: List<Recipe>) {
        deleteAll()
        insertRecipes(recipes)
    }
}