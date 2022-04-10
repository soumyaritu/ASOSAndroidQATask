/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.data.entity

import com.google.gson.annotations.SerializedName

data class RecipeEntity(
        @SerializedName("name") val name: String,
        @SerializedName("imageURL") val imageUrl: String,
        @SerializedName("originalURL") val originalUrl: String?,
        @SerializedName("steps") val steps: List<String>,
        @SerializedName("timers") val timers: List<Int>,
        @SerializedName("ingredients") val ingredients: List<IngredientEntity>)