/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.ui.splash

import com.asos.recipes.globalutils.logger.Logger
import com.asos.recipes.presentation.navigation.Navigator
import javax.inject.Inject

class SplashPresenter @Inject constructor(
        private val navigator: Navigator,
        private val logger: Logger): SplashContract.Presenter {

    companion object {
        private val TAG: String = SplashPresenter::class.java.simpleName
        private val DELAY_MILLIS = 2000L
    }

    override var view: SplashContract.View? = null

    override fun initialize() {
        Thread {
            Thread.sleep(DELAY_MILLIS)
            logger.d(TAG, "Navigating to home after the delay")
            navigator.navigateToHome()
            view?.finish()
        }.start()
    }

    override fun onDestroy() { this.view = null }

}