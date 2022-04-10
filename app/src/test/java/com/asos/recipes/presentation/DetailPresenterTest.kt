/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation

import com.asos.recipes.domain.exception.RepositoryException
import com.asos.recipes.domain.model.Recipe
import com.asos.recipes.domain.repository.Repository
import com.asos.recipes.domain.usecase.GetRecipeByName
import com.asos.recipes.factories.DummyRecipesFactory.givenARecipe
import com.asos.recipes.globalutils.logger.Logger
import com.asos.recipes.presentation.threading.TestExecutor
import com.asos.recipes.presentation.threading.TestMainThread
import com.asos.recipes.presentation.ui.detail.DetailContract
import com.asos.recipes.presentation.ui.detail.DetailPresenter
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString

class DetailPresenterTest {

    private lateinit var scheduler: TestScheduler
    private lateinit var presenter: DetailPresenter
    private val mockView: DetailContract.View = mock()
    private val mockLogger: Logger = mock()
    private val mockRepository: Repository = mock()

    @Before
    fun setUp() {
        scheduler = TestScheduler()
        presenter = createMockedPresenter()
        presenter.view = mockView
    }

    @Test
    fun `should show the loading screen when it has been initialized`() {
        givenTheRepositoryReturns(givenARecipe())
        presenter.initialize()
        verify(mockView).showLoading()
    }

    @Test
    fun `should hide the loading screen when the response is successful`() {
        givenTheRepositoryReturns(givenARecipe())
        presenter.initialize()
        scheduler.triggerActions()
        verify(mockView).hideLoading()
    }

    @Test
    fun `should finish the view when the response is an error`() {
        givenTheRepositoryReturns(RepositoryException.RecipeNotFoundException())
        presenter.initialize()
        scheduler.triggerActions()
        verify(mockView).finish()
    }

    @Test
    fun `should render the recipe if the response is successful`() {
        val recipe = givenARecipe()
        givenTheRepositoryReturns(recipe)
        presenter.initialize()
        scheduler.triggerActions()
        verify(mockView).render(recipe)
    }

    private fun createMockedPresenter(): DetailPresenter {
        val mockGetRecipe = GetRecipeByName(TestExecutor(scheduler), TestMainThread(scheduler), mockRepository)
        return DetailPresenter(mockGetRecipe, mockLogger)
    }

    private fun givenTheRepositoryReturns(recipe: Recipe) {
        whenever(mockRepository.getRecipeByName(anyString())).thenReturn(Observable.just(recipe))
    }

    private fun givenTheRepositoryReturns(exception: Exception) {
        whenever(mockRepository.getRecipeByName(anyString())).thenReturn(Observable.error(exception))
    }
}