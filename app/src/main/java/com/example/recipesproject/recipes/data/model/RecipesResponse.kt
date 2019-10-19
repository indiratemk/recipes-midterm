package com.example.recipesproject.recipes.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecipesResponse (

    @SerializedName("count")
    @Expose
    val count: Int,

    @SerializedName("recipes")
    @Expose
    val recipes: List<Recipe>
)