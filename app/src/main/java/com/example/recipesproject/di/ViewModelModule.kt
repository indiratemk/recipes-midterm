package com.example.recipesproject.di

import com.example.recipesproject.recipes.data.RecipesRepository
import com.example.recipesproject.recipes.presentation.vm.RecipesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { RecipesViewModel(get() as RecipesRepository) }
}