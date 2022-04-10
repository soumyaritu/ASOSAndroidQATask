/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.data.mapper

import com.asos.recipes.data.entity.IngredientEntity
import com.asos.recipes.domain.model.Ingredient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IngredientEntityMapper @Inject constructor() {

    operator fun invoke(entity: IngredientEntity): Ingredient = with(entity) {
        Ingredient(
                name = name,
                type = type,
                quantity = quantity)
    }

}