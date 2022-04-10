/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.domain.model

sealed class DifficultyFilter : Filter {

    companion object {
        private const val EASY_INGREDIENTS_LIMIT = 5
        private const val MEDIUM_INGREDIENTS_LIMIT = 10
    }

    object All : DifficultyFilter() {
        override fun invoke(recipe: Recipe): Boolean = true
    }
    object Easy : DifficultyFilter() {
        override fun invoke(recipe: Recipe): Boolean {
            return recipe.totalIngredients <= EASY_INGREDIENTS_LIMIT
        }
    }
    object Medium : DifficultyFilter() {
        override fun invoke(recipe: Recipe): Boolean {
            return recipe.totalIngredients in (EASY_INGREDIENTS_LIMIT + 1)..MEDIUM_INGREDIENTS_LIMIT
        }
    }
    object Hard : DifficultyFilter() {
        override fun invoke(recipe: Recipe): Boolean {
            return recipe.totalIngredients > MEDIUM_INGREDIENTS_LIMIT
        }
    }

    override fun toString(): String = javaClass.simpleName
}