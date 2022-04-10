/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.data.api

import com.asos.recipes.data.entity.RecipeEntity

interface Api {

    fun getRecipes(): List<RecipeEntity>

}
