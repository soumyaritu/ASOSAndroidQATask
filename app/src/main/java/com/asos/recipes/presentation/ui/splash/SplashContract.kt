/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.ui.splash

import com.asos.recipes.presentation.base.BasePresenter

interface SplashContract {

    interface Presenter : BasePresenter<View>

    interface View {
        fun finish()
    }
}