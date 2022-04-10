/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.data.cache

import com.asos.recipes.data.entity.RecipeEntity

interface Cache {

    fun isEmpty(): Boolean

    fun put(entity: RecipeEntity)

    fun putAll(entities: List<RecipeEntity>)

    fun get(name: String): RecipeEntity?

    fun getAll(): List<RecipeEntity>

    fun invalidate()

}