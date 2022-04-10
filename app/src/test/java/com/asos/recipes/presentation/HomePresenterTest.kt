/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation

import com.asos.recipes.domain.exception.RepositoryException
import com.asos.recipes.domain.model.Recipe
import com.asos.recipes.domain.repository.Repository
import com.asos.recipes.domain.usecase.GetRecipes
import com.asos.recipes.factories.DummyRecipesFactory.givenARecipe
import com.asos.recipes.factories.DummyRecipesFactory.givenARecipesList
import com.asos.recipes.globalutils.logger.Logger
import com.asos.recipes.presentation.navigation.Navigator
import com.asos.recipes.presentation.threading.TestExecutor
import com.asos.recipes.presentation.threading.TestMainThread
import com.asos.recipes.presentation.ui.home.HomeContract
import com.asos.recipes.presentation.ui.home.HomePresenter
import com.nhaarman.mockito_kotlin.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test

class HomePresenterTest {

    private lateinit var scheduler: TestScheduler
    private lateinit var presenter: HomePresenter
    private val mockView: HomeContract.View = mock()
    private val mockNavigator: Navigator = mock()
    private val mockLogger: Logger = mock()
    private val mockRepository: Repository = mock()

    @Before
    fun setUp() {
        scheduler = TestScheduler()
        presenter = createMockedPresenter()
        presenter.view = mockView
    }

    @Test
    fun `should show the loading screen after been initialized`() {
        givenTheRepositoryReturns(givenARecipesList())
        presenter.initialize()
        verify(mockView).showLoading()
    }

    @Test
    fun `should hide the loading screen after a successful response`() {
        givenTheRepositoryReturns(givenARecipesList())
        presenter.initialize()
        scheduler.triggerActions()
        verify(mockView).hideLoading()
    }

    @Test
    fun `should hide the loading screen after an error response`() {
        givenTheRepositoryReturns(RepositoryException.RecipesNotFoundException())
        presenter.initialize()
        scheduler.triggerActions()
        verify(mockView).hideLoading()
    }

    @Test
    fun `should render the recipes list if the response is not empty`() {
        val recipes = givenARecipesList()
        givenTheRepositoryReturns(recipes)
        presenter.initialize()
        scheduler.triggerActions()
        verify(mockView).render(recipes)
        verify(mockView).hideEmpty()
    }

    @Test
    fun `should show the empty view if the result list is empty`() {
        givenTheRepositoryReturns(emptyList())
        presenter.initialize()
        scheduler.triggerActions()
        verify(mockView).showEmpty()
    }

    @Test
    fun `should show the recipe detail when a recipe is clicked`() {
        val recipe = givenARecipe()
        presenter.onRecipeClick(recipe)
        verify(mockNavigator).navigateToDetail(recipe.name)
    }

    private fun createMockedPresenter(): HomePresenter {
        val mockGetRecipes = GetRecipes(TestExecutor(scheduler), TestMainThread(scheduler), mockRepository)
        return HomePresenter(mockGetRecipes, mockNavigator, mockLogger)
    }

    private fun givenTheRepositoryReturns(recipes: List<Recipe>) {
        whenever(mockRepository.getRecipes(any())).thenReturn(Observable.just(recipes))
    }

    private fun givenTheRepositoryReturns(exception: Exception) {
        whenever(mockRepository.getRecipes(any())).thenReturn(Observable.error(exception))
    }

}