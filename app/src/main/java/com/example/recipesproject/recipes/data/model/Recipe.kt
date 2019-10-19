package com.example.recipesproject.recipes.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "recipes")
data class Recipe (

    @PrimaryKey
    @ColumnInfo(name = "recipe_id")
    @SerializedName("recipe_id")
    @Expose
    val recipeId: String,

    @ColumnInfo(name = "publisher")
    @SerializedName("publisher")
    @Expose
    val publisher: String,

    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    val title: String,

    @ColumnInfo(name = "image_url")
    @SerializedName("image_url")
    @Expose
    val imageUrl: String
)