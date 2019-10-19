package com.example.recipesproject.di

import android.content.Context
import androidx.room.Room
import com.example.recipesproject.db.AppDatabase
import com.example.recipesproject.recipes.data.local.RecipesLocalDataSource
import com.example.recipesproject.recipes.data.local.dao.RecipeDao
import com.example.recipesproject.util.Constants
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {
    single { provideDatabase(androidContext()) }

    single { get<AppDatabase>().getRecipeDao() }

    single { RecipesLocalDataSource(get() as RecipeDao) }
}

fun provideDatabase(context: Context): AppDatabase {
    return Room.databaseBuilder(context, AppDatabase::class.java, Constants.DB_NAME).build()
}