/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.domain.model

interface Filter {
    operator fun invoke(recipe: Recipe): Boolean
}