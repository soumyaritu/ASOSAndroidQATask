/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.data

import com.asos.recipes.data.cache.CacheImpl
import com.asos.recipes.factories.DummyRecipeEntitiesFactory.givenAListOfRecipeEntities
import com.asos.recipes.factories.DummyRecipeEntitiesFactory.givenARecipeEntity
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CacheImplTest {

    private lateinit var cache: CacheImpl

    @Before
    fun setUp() {
        cache = CacheImpl()
    }

    @Test
    fun `should be empty after being created`() {
        assertTrue(cache.isEmpty())
    }

    @Test
    fun `should contain a recipe if it is inserted`() {
        val entity = givenARecipeEntity()
        assertNull(cache.get(entity.name))
        cache.put(entity)
        assertFalse(cache.isEmpty())
        assertSame(entity, cache.get(entity.name))
    }

    @Test
    fun `should contain all the inserted values`() {
        val entities = givenAListOfRecipeEntities()
        cache.putAll(entities)
        assertFalse(cache.isEmpty())
        assertEquals(entities.size, cache.getAll().size)
        assertTrue(entities.all { cache.get(it.name) != null })
    }

    @Test
    fun `should be empty after been invalidated`() {
        cache.putAll(givenAListOfRecipeEntities())
        assertFalse(cache.isEmpty())
        cache.invalidate()
        assertTrue(cache.isEmpty())
        assertTrue(cache.getAll().isEmpty())
    }

}