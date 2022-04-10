/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.domain.repository

import com.asos.recipes.domain.model.Recipe
import com.asos.recipes.domain.usecase.GetRecipesParams
import io.reactivex.rxjava3.core.Observable

interface Repository {

    fun getRecipes(params: GetRecipesParams): Observable<List<Recipe>>

    fun getRecipeByName(name: String): Observable<Recipe>

}