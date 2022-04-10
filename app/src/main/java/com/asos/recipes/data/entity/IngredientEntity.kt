/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.data.entity

import com.google.gson.annotations.SerializedName

data class IngredientEntity(
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("quantity") val quantity: String
)