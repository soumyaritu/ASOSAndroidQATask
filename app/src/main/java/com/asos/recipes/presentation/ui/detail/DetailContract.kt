/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.ui.detail

import com.asos.recipes.domain.model.Recipe
import com.asos.recipes.presentation.base.BasePresenter

interface DetailContract {

    interface Presenter : BasePresenter<View>

    interface View {
        val recipeName: String
        fun render(recipe: Recipe)
        fun showLoading()
        fun hideLoading()
        fun finish()
    }

}