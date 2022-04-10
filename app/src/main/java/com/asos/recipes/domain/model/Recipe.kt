/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.domain.model

data class Recipe(
        val name: String,
        val imageUrl: String,
        val originalUrl: String,
        val steps: List<String>,
        val timers: List<Int>,
        val ingredients: List<Ingredient>) {

    val totalMinutes: Int get() = timers.reduce { total, minutes -> total + minutes }

    val totalIngredients: Int get() = ingredients.size

    val totalSteps: Int get() = steps.size

    fun contains(text: String): Boolean {
        return name.contains(text, ignoreCase = true)
                || steps.any { it.contains(text, ignoreCase = true) }
                || ingredients.any { it.name.contains(text, ignoreCase = true) }
    }

}