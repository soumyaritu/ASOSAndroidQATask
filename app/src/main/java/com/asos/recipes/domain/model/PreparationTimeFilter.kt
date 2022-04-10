/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.domain.model

sealed class PreparationTimeFilter : Filter {

    companion object {
        private const val FAST_TIME_LIMIT = 30
        private const val MEDIUM_TIME_LIMIT = 60
    }

    object All : PreparationTimeFilter() {
        override fun invoke(recipe: Recipe): Boolean = true
    }
    object Fast : PreparationTimeFilter() {
        override fun invoke(recipe: Recipe): Boolean {
            return recipe.totalMinutes <= FAST_TIME_LIMIT
        }
    }
    object Medium : PreparationTimeFilter() {
        override fun invoke(recipe: Recipe): Boolean {
            return recipe.totalMinutes in (FAST_TIME_LIMIT + 1)..MEDIUM_TIME_LIMIT
        }
    }
    object Slow : PreparationTimeFilter() {
        override fun invoke(recipe: Recipe): Boolean {
            return recipe.totalMinutes > MEDIUM_TIME_LIMIT
        }
    }

    override fun toString(): String = javaClass.simpleName
}