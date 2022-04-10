/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.ui.home

import com.asos.recipes.domain.model.Recipe
import com.asos.recipes.domain.model.DifficultyFilter
import com.asos.recipes.domain.model.PreparationTimeFilter
import com.asos.recipes.presentation.base.BasePresenter

class HomeContract {

    interface Presenter : BasePresenter<View> {
        fun refresh()
        fun onRecipeClick(recipe: Recipe)
    }

    interface View {
        val searchText: String
        val difficultyFilter: DifficultyFilter
        val preparationTimeFilter: PreparationTimeFilter
        fun render(recipes: List<Recipe>)
        fun showLoading()
        fun hideLoading()
        fun showEmpty()
        fun hideEmpty()
    }

}