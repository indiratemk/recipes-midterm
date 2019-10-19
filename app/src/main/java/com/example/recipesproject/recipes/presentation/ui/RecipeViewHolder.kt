package com.example.recipesproject.recipes.presentation.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipesproject.recipes.data.model.Recipe
import kotlinx.android.synthetic.main.vh_recipe.view.*

class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val ivRecipe = view.ivRecipeImage
    private val tvTitle = view.tvTitle
    private val tvPublisher = view.tvPublisher

    fun onBind(recipe: Recipe) {
        Glide.with(itemView.context)
            .load(recipe.imageUrl)
            .into(ivRecipe)
        tvTitle.text = recipe.title
        tvPublisher.text = recipe.publisher
    }
}