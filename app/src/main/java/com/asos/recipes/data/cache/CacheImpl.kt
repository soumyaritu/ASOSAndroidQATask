/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.data.cache

import com.asos.recipes.data.entity.RecipeEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CacheImpl @Inject constructor(): Cache {

    private val content = mutableMapOf<String, RecipeEntity>()

    override fun isEmpty(): Boolean = content.isEmpty()

    override fun put(entity: RecipeEntity) { content.put(entity.name, entity) }

    override fun putAll(entities: List<RecipeEntity>) = entities.forEach { put(it) }

    override fun get(name: String): RecipeEntity? = content[name]

    override fun getAll(): List<RecipeEntity> = content.values.toList()

    override fun invalidate() = content.clear()

}