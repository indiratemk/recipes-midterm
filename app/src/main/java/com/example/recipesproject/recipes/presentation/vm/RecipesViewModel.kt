package com.example.recipesproject.recipes.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recipesproject.base.vm.BaseViewModel
import com.example.recipesproject.recipes.data.model.Recipe
import com.example.recipesproject.recipes.data.IRecipesRepository
import com.example.recipesproject.util.Resource
import kotlinx.coroutines.launch

class RecipesViewModel(private val recipesRepository: IRecipesRepository): BaseViewModel() {

    private val _recipes = MutableLiveData<Resource<List<Recipe>>>()

    val recipes: LiveData<Resource<List<Recipe>>>
        get() = _recipes

    fun getRecipes() {
        coroutineContext.launch {
            _recipes.value = Resource.Loading(null)
            _recipes.value = recipesRepository.getRecipes()
        }
    }
}