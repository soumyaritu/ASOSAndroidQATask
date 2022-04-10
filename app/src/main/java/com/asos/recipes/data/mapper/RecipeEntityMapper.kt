/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.data.mapper

import com.asos.recipes.data.entity.RecipeEntity
import com.asos.recipes.domain.model.Recipe
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeEntityMapper @Inject constructor(
        private val ingredientMapper: IngredientEntityMapper) {

    operator fun invoke(entity: RecipeEntity): Recipe = with(entity) {
        Recipe(
                name = name,
                imageUrl = imageUrl,
                originalUrl = originalUrl ?: "",
                steps = steps,
                timers = timers,
                ingredients = ingredients.map { ingredientMapper(it) })
    }

}