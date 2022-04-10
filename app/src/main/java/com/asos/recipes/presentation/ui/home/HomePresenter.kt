/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.ui.home

import com.asos.recipes.domain.model.Recipe
import com.asos.recipes.domain.model.DifficultyFilter
import com.asos.recipes.domain.model.PreparationTimeFilter
import com.asos.recipes.domain.usecase.GetRecipes
import com.asos.recipes.domain.usecase.GetRecipesParams
import com.asos.recipes.domain.usecase.SimpleObserver
import com.asos.recipes.globalutils.logger.Logger
import com.asos.recipes.presentation.navigation.Navigator
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class HomePresenter @Inject constructor(
        private val getRecipes: GetRecipes,
        private val navigator: Navigator,
        private val logger: Logger): HomeContract.Presenter {

    companion object {
        private val TAG: String = HomePresenter::class.java.simpleName
    }

    override var view: HomeContract.View? = null
    private val subscriptions = mutableListOf<Disposable>()

    override fun initialize() {
        view?.showLoading()
        refresh()
    }

    override fun refresh() {
        // Get params from view
        val searchText: String = view?.searchText ?: ""
        val difficultyFilter = view?.difficultyFilter ?: DifficultyFilter.All
        val preparationTimeFilter = view?.preparationTimeFilter ?: PreparationTimeFilter.All
        // Execute usecase
        getRecipes.params = GetRecipesParams(searchText, difficultyFilter, preparationTimeFilter)
        getRecipes.execute(SimpleObserver(
                onSubscribe = this::onSubscription,
                onNext = this::onRecipesResult,
                onError = this::onRecipesLoadError))
        logger.d(TAG, "difficulty=$difficultyFilter,preparation=$preparationTimeFilter,search=\"$searchText\"")
    }

    private fun onRecipesResult(recipes: List<Recipe>) {
        if (recipes.isNotEmpty()) {
            view?.render(recipes)
            view?.hideEmpty()
            view?.hideLoading()
        } else view?.showEmpty()
    }

    private fun onRecipesLoadError(cause: Throwable) {
        view?.hideLoading()
        logger.e(TAG, "Error loading recipes: ${cause.message}")
    }

    override fun onRecipeClick(recipe: Recipe) { navigator.navigateToDetail(recipe.name) }

    private fun onSubscription(disposable: Disposable) { this.subscriptions.add(disposable) }

    override fun onDestroy() {
        this.subscriptions.forEach { it.dispose() }
        this.view = null
    }

}