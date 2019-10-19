package com.example.recipesproject.di

import com.example.recipesproject.recipes.data.RecipesRepository
import com.example.recipesproject.recipes.data.local.RecipesLocalDataSource
import com.example.recipesproject.recipes.data.remote.RecipesRemoteDataSource
import org.koin.dsl.module

val repoModule = module {
    single { RecipesRepository(get() as RecipesRemoteDataSource, get() as RecipesLocalDataSource) }
}