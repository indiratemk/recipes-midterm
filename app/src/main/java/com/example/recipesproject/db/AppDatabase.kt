package com.example.recipesproject.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recipesproject.recipes.data.local.dao.RecipeDao
import com.example.recipesproject.recipes.data.model.Recipe

@Database(entities = [Recipe::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getRecipeDao(): RecipeDao
}