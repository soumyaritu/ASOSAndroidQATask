/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.ui.detail

import com.asos.recipes.domain.model.Recipe
import com.asos.recipes.domain.usecase.GetRecipeByName
import com.asos.recipes.domain.usecase.SimpleObserver
import com.asos.recipes.globalutils.logger.Logger
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class DetailPresenter @Inject constructor(
        private val getRecipe: GetRecipeByName,
        private val logger: Logger): DetailContract.Presenter {

    companion object {
        private val TAG: String = DetailPresenter::class.java.simpleName
    }

    override var view: DetailContract.View? = null
    private var disposable: Disposable? = null

    override fun initialize() {
        view?.showLoading()
        getRecipe.name = view?.recipeName ?: ""
        getRecipe.execute(SimpleObserver(
                onSubscribe = this::onSubscription,
                onNext = this::onRecipeLoadSuccess,
                onError = this::onRecipeLoadError))
    }

    private fun onSubscription(disposable: Disposable) { this.disposable = disposable }

    private fun onRecipeLoadSuccess(recipe: Recipe) {
        view?.render(recipe)
        view?.hideLoading()
    }

    private fun onRecipeLoadError(cause: Throwable) {
        logger.e(TAG, "Error loading recipe: ${cause.message}")
        view?.hideLoading()
        view?.finish()
    }

    override fun onDestroy() {
        this.disposable?.dispose()
        this.view = null
    }

}