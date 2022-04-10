/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.data

import com.asos.recipes.data.api.Api
import com.asos.recipes.data.cache.Cache
import com.asos.recipes.data.entity.RecipeEntity
import com.asos.recipes.data.mapper.RecipeEntityMapper
import com.asos.recipes.data.repository.RepositoryImpl
import com.asos.recipes.domain.model.Recipe
import com.asos.recipes.domain.usecase.GetRecipesParams
import com.asos.recipes.factories.DummyRecipeEntitiesFactory.givenARecipeEntity
import com.asos.recipes.factories.DummyRecipesFactory.givenARecipe
import com.asos.recipes.globalutils.logger.Logger
import com.nhaarman.mockito_kotlin.*
import io.reactivex.rxjava3.core.Observer
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString


class RepositoryImplTest {

    companion object {
        private const val NOT_SEARCHABLE_TEXT = "Not searchable text"
    }

    private lateinit var repository: RepositoryImpl
    private val mockApi: Api = mock()
    private val mockCache: Cache = mock()
    private val mockMapper: RecipeEntityMapper = mock()
    private val mockLogger: Logger = mock()

    @Before
    fun setUp() {
        repository = RepositoryImpl(mockApi, mockCache, mockMapper, mockLogger)
    }

    @Test
    fun `should call the api if the cache is empty`() {
        whenever(mockCache.isEmpty()).thenReturn(true)
        repository.getRecipes(GetRecipesParams()).subscribe()
        verify(mockApi).getRecipes()
    }

    @Test
    fun `should return a list of recipes from the cache if it is not empty`() {
        whenever(mockCache.isEmpty()).thenReturn(false)
        repository.getRecipes(GetRecipesParams()).subscribe()
        verify(mockCache).getAll()
        verify(mockApi, never()).getRecipes()
    }

    @Test
    fun `should return a recipe if it is in the cache`() {
        val anyEntity = givenARecipeEntity()
        val anyRecipe = givenARecipe()
        whenever(mockCache.get(anyString())).thenReturn(anyEntity)
        whenever(mockMapper.invoke(anyEntity)).thenReturn(anyRecipe)
        val mockObserver: Observer<Recipe> = mock()
        repository.getRecipeByName(anyString()).subscribe(mockObserver)
        verify(mockObserver).onNext(anyRecipe)
    }

    @Test
    fun `should return an error if the recipe is not in the cache`() {
        whenever(mockCache.get(anyString())).thenReturn(null)
        val mockObserver: Observer<Recipe> = mock()
        repository.getRecipeByName(anyString()).subscribe(mockObserver)
        verify(mockObserver).onError(any())
    }

    @Test
    fun `should return an empty list if the search text is not found`() {
        val anyEntity = givenARecipeEntity()
        val anyRecipe = givenARecipe()
        givenTheCacheReturns(listOf(anyEntity))
        whenever(mockMapper.invoke(anyEntity)).thenReturn(anyRecipe)
        val mockObserver: Observer<List<Recipe>> = mock()
        val captor: KArgumentCaptor<List<Recipe>> = argumentCaptor()
        repository.getRecipes(GetRecipesParams(searchText = NOT_SEARCHABLE_TEXT)).subscribe(mockObserver)
        verify(mockObserver).onNext(captor.capture())
        assertTrue(captor.firstValue.isEmpty())
    }

    @Test
    fun `should return a non-empty list if the search text is valid`() {
        val anyEntity = givenARecipeEntity()
        val anyRecipe = givenARecipe()
        givenTheCacheReturns(listOf(anyEntity))
        whenever(mockMapper.invoke(anyEntity)).thenReturn(anyRecipe)
        val mockObserver: Observer<List<Recipe>> = mock()
        val captor: KArgumentCaptor<List<Recipe>> = argumentCaptor()
        repository.getRecipes(GetRecipesParams(searchText = anyRecipe.name)).subscribe(mockObserver)
        verify(mockObserver).onNext(captor.capture())
        assertFalse(captor.firstValue.isEmpty())
        assertEquals(anyRecipe, captor.firstValue.first())
    }

    private fun givenTheCacheReturns(entities: List<RecipeEntity>) {
        whenever(mockCache.isEmpty()).thenReturn(false)
        whenever(mockCache.getAll()).thenReturn(entities)
    }

}