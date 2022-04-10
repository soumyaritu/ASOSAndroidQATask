/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.domain.exception

sealed class RepositoryException: Exception() {
    class RecipesNotFoundException : RepositoryException()
    class RecipeNotFoundException : RepositoryException()
}